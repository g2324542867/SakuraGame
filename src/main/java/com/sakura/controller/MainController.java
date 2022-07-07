package com.sakura.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.security.PermitAll;

@PermitAll
@Controller
public class MainController
{
    @GetMapping
    public String index()
    {
        return "index";
    }
}
