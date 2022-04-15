package com.studentmanagement.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InfoController {

    @GetMapping("/about-us")
    public String getInfo(){
        return "about-us";
    }
}
