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


    // 用户登录 主体代码在mainController
    @RequestMapping
    public String login(String username, String password){

        return "";
    }

    // 三级地址

    // 头像修改

    // 用户资料更新

    // 用户修改简介

    // 新增用户
    

    // 第三方登录qq

    // 扫码登录

    // 短信验证找回密码

    // 邮箱注册

    // 余额充值


}
