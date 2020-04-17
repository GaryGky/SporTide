package com.hupu.controller;

import com.hupu.service.Impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class LoginController {
    @Autowired
    @Qualifier("adminServiceImpl")
    private AdminServiceImpl adminService;
    
    @RequestMapping("adminLogin")
    public String varifyLogIn(String name, String password, HttpSession session) {
        session.setAttribute("admin_id",);
        if (adminService.queryPwdByName(name).equals(password)) {
            return "loginSuccess";
        } else {
            return "loginFail";
        }
    }
    
}
