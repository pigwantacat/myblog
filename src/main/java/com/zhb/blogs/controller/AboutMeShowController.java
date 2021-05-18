package com.zhb.blogs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutMeShowController {
    @GetMapping("/aboutme")
    public String getAboutme(){
        return "aboutme";
    }
}
