package com.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/index")
    public String getIndex(){
        return "index";
    }

    @RequestMapping("/login")
    public String getLogin(){
        return "login";
    }
}
