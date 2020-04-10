package com.hupu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JumpController {
    // 用于页面跳转
    @RequestMapping("/toScore")
    public String gotoScore(){
        return "score";
    }
    
}
