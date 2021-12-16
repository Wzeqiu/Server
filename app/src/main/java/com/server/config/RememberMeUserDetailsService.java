package com.server.config;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class RememberMeUserDetailsService implements UserDetailsService {


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        LoginAccountInfoVO loginAccountInfo = userAccountService.getLoginAccountInfo(username);
//        if (loginAccountInfo == null) {
//            throw new AuthenticationServiceException("用户名或密码不正确");
//        }
//        if (Constant.账号状态_禁用.equals(loginAccountInfo.getState())) {
//            throw new AuthenticationServiceException(Constant.登录提示_账号已被禁用);
//        }
//        UserAccountDetails userAccountDetails = new UserAccountDetails(loginAccountInfo);
//        return userAccountDetails;

        return null;
    }

}
