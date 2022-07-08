package com.sakura.controller;

import com.sakura.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller
@RequestMapping("")
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;


    // 用户登录 主体代码在
    @RequestMapping
    public String login(String username, String password){

        return "";
    }
}
