package com.sakura.controller;

import com.sakura.entity.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import java.util.Collection;

//@PermitAll
@Controller

public class MainController
{
//    @GetMapping
    public String index()
    {
        return "index";
    }


    @PermitAll
    @GetMapping("/login.html")
    public String t1() {

        return "login";
    }


    @PreAuthorize("hasAnyRole('user','admin','vip','svip')")
    @RequestMapping("/success.html")
    public String t2() {
        SecurityContext context = SecurityContextHolder.getContext(); // 上下文
        Authentication authentication = context.getAuthentication(); // 认证信息
        if (authentication.isAuthenticated()) {

            String username = authentication.getName(); // 用户名
            Object principal =  authentication.getPrincipal(); // 唯一用户对象，一般是UserDetails


            System.out.println(username+"--------"+principal);

        }
        System.out.println("成功");
        return "index";
    }

    @PermitAll
    @RequestMapping("/403.html")
    public String t4() {
        return "403";
    }


}
