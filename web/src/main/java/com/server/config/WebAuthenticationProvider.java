package com.server.config;

import org.attoparser.util.TextUtil;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
public class WebAuthenticationProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String userName = authentication.getName();
        String pwd = (String) authentication.getCredentials();
        System.err.println("userName is " + userName);
        System.err.println("pwd is " + pwd);
        if (userName.isEmpty() || !"wang".equals(userName)) {
            throw new AuthenticationServiceException("账号不存在");
        }
        if (!pwd.equals("wang")) {
            throw new AuthenticationServiceException("密码错误");
        }
        UserAccountDetails userAccountDetails = new UserAccountDetails();
        return new UsernamePasswordAuthenticationToken(userName, pwd, userAccountDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return UsernamePasswordAuthenticationToken.class.equals(aClass);
    }
}
