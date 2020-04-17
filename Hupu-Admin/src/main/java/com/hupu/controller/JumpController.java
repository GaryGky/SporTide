package com.hupu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JumpController {
    // 用于页面跳转
    @RequestMapping("/toGameTable")
    public String gotoGameTab() {
        return "Hupu_GameTable";
    }
    
    @RequestMapping("/toGameAdd")
    public String gotoGameAdd() {
        return "Hupu_GameAdd";
    }
    
    @RequestMapping("/toUserTable")
    public String gotoUserTab() {
        return "Hupu_UserTable";
    }
    
    @RequestMapping("/toAdminAdd")
    public String gotoAdminAdd() {
        return "Hupu_AdminAdd";
    }
    
    @RequestMapping("/toPostTable")
    public String gotoPostTable() {
        return "Hupu_PostingTable";
    }
    
    @RequestMapping("/toComTable")
    public String gotoComTab() {
        return "Hupu_CommentTable";
    }
    
    @RequestMapping("/toHome")
    public String gotoLogin() {
        return "Hupu_Home";
    }
    
}
