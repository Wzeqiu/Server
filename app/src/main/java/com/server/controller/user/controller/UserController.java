package com.server.controller.user.controller;

import com.alibaba.fastjson.JSONObject;
import com.server.common.vo.Result;
import com.server.user.vo.UserAccountDetails;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {


    @GetMapping(value = "/userInfo")
    @ResponseBody
    public Result getUserInfo() {
        UserAccountDetails user = (UserAccountDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return Result.success().setData(user);
    }

}
