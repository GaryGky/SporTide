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
    
    @RequestMapping("/adminLogin")
    public String varifyLogIn(String name, String password, HttpSession session) {
        System.out.println("name === >" + name);
        System.out.println("pwd === >" + password);
        System.out.println("right pwd ===> " + adminService.queryPwdByName(name));
        if (name == null || password == null) {
            return "loginFail";
        } // 如果输入字段为空，直接fail
        if (adminService.queryPwdByName(name).equals(password)) {
            session.setAttribute("admin_name", name); // 成功登录，把信息加入session
            return "loginSuccess";
        } else {
            return "loginFail";
        }
    }
    
    @RequestMapping("/logout")
    public String logOut(HttpSession session) {
        session.removeAttribute("admin_name");
        return "logOut";
    }
}
