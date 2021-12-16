package com.server.controller.user.controller;

import com.server.user.vo.UserAccountDetails;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/user")
public class UserController {


    @RequestMapping(value = "userInfo", method = RequestMethod.GET)
    public UserAccountDetails getUserInfo() {
        UserAccountDetails user = (UserAccountDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user;
    }

}
