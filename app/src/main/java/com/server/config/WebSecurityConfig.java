package com.server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private WebAuthenticationProvider webAuthenticationProvider;

    @Autowired
    private AuthenticationFailHandler authenticationFailHandler;

    @Autowired
    private AuthenticationSuccessHandler authenticationSuccessHandler;

    @Autowired
    private CustomAuthenticationEntryPoint authenticationEntryPoint;

    @Autowired
    private SessionExpiredStrategy sessionExpiredStrategy;


    @Autowired
    private LogoutHandler logoutHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests() //授权配置
                .antMatchers("/login").permitAll() //登录路径放行
                .anyRequest().authenticated()  //其他路径都要认证之后才能访问
                .and()
                .formLogin()//允许表单登录
                .loginPage("/login") //这个就是自定义的登录页面
                .loginProcessingUrl("/login") //告诉框架，现在的登录请求的URL地址是:/login
                .successHandler(authenticationSuccessHandler)//设置认证成功后，handler的处理器
                .failureHandler(authenticationFailHandler)//设置认证失败后handler的处理器
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessHandler(logoutHandler)
                .clearAuthentication(true)      //清除认证信息
                .permitAll()                    //登出路径放行 /logout。这是框架自带的登出请求
                .and()
                .csrf().disable()//禁止匿名  关闭csrf
                .headers().frameOptions().disable();

        //异常处理
        http.exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPoint);//身份认证验证失败配置

        http.sessionManagement()
                .maximumSessions(1)
                .expiredSessionStrategy(sessionExpiredStrategy);


    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(webAuthenticationProvider);
    }


}
