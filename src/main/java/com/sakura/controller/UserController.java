package com.sakura.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/*
*   说明：用户控制器，进行用户操作的控制
* */

@Controller
public class UserController {

    @RequestMapping("/login")
    public String login(Model model){
        return "login";
    }

}
