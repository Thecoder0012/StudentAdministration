package com.studentmanagement.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    @GetMapping("/index")
    public String getIndex(){
        return "home/index";
    }

    @GetMapping("/about-us")
    public String getInfoPage(){
        return "home/about-us";
    }
}
