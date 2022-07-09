package com.sakura.controller;

import com.sakura.entity.User;
import com.sakura.entity.UserRole;
import com.sakura.service.IUserRoleService;
import com.sakura.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.security.PermitAll;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("")
@RequiredArgsConstructor
@SessionAttributes(value = {"user"})
@PermitAll
public class UserController {

    @Value("${upload.location}")
    private String location;

    private final IUserService userService;
    private final IUserRoleService userRoleService;


    // 用户登录 主体代码在mainController
//    @RequestMapping
    public String login(String username, String password){

        return "";
    }


    @PreAuthorize("hasAnyRole('user','admin','vip','svip')")
    @RequestMapping("/success.html")
    public String t2(Model model) {
        SecurityContext context = SecurityContextHolder.getContext(); // 上下文
        Authentication authentication = context.getAuthentication(); // 认证信息
        if (authentication.isAuthenticated()) {

            String username = authentication.getName(); // 用户名
            Object principal =  authentication.getPrincipal(); // 唯一用户对象，一般是UserDetails

            model.addAttribute("user",principal);

            System.out.println(username+"--------"+principal);

        }
        System.out.println("成功");
        return "index";
    }

    // 三级地址

    // 头像修改
    @PermitAll
    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file, Model m) {
        try {

            String fileName = UUID.randomUUID() + file.getOriginalFilename();
            //上传文件存储的位置
            String destFileName = location + fileName;
            //防止改文件夹不存在，创建一个新文件夹
            File destFile = new File(location,fileName);
            destFile.getParentFile().mkdirs();
            //将文件存储到该位置
            file.transferTo(destFile);
            //传递文件
            m.addAttribute("fileName", fileName);
            //将文件名存储到数据库中，以便查询调用

        } catch (IOException e) {
            e.printStackTrace();
            return "上传失败," + e.getMessage();
        }
        return "test";
    }


    // 用户资料更新

    // 用户修改简介



    // 新增用户
    @PermitAll
    @PostMapping(path = "/register")
    public String register(User user){

        userService.registerUser(user);

        return "test";
    }
    

    // 第三方登录qq

    // 扫码登录

    // 短信验证找回密码

    // 邮箱注册

    // 余额充值


}
