package com.sakura.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;

//@PermitAll
@Controller
@DenyAll
public class MainController
{
    @GetMapping
    public String index()
    {
        return "index";
    }


    @PermitAll
    @GetMapping("/login.html")
    public String t1() {

        return "login";
    }


    @PreAuthorize("hasRole('root')")
    @RequestMapping("/success.html")
    public String t2() {
        return "index";
    }

    @PermitAll
    @RequestMapping("/403.html")
    public String t4() {
        return "403";
    }


/*    @RequestMapping("/error")
    public String t5() {
        return "error";
    }*/
}
