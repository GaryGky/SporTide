package com.hupu.controller;

import com.hupu.pojo.User;
import com.hupu.service.Impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    @Qualifier("adminServiceImpl")
    private AdminServiceImpl adminService;
    
    private int pageNum = 1;
    
    @RequestMapping("/addPageNum")
    public void addPageNum() {
        pageNum++;
        System.out.println("pageNum===>" + pageNum);
    }
    
    @RequestMapping("/subPageNum")
    public void subPageNum() {
        pageNum--;
        if (pageNum <= 0) {
            pageNum = 1;
        }
        System.out.println("=pageNum===>" + pageNum);
    }
    
    @RequestMapping("/adminLogin")
    public int varifyLogIn(String name, String password,
                              HttpSession session) {
        System.out.println("输入密码 ===>> " + password);
        System.out.println("正确密码 ===>> " + adminService.queryPwdByName(name));
        
        if (name == null || password == null) {
            return -1;
        } // 如果输入字段为空，直接fail
        try {
            if (adminService.queryPwdByName(name).equals(password)) {
                session.setAttribute("admin", name); //
                // 成功登录，把信息加入session
                return 1;
            } else {
                return 0;
            }
        } catch (Exception e) {
            return 0;
        }
    }
    
    @RequestMapping("/logout")
    public String logOut(HttpSession session) {
        session.removeAttribute("admin");
        return "logOut";
    }
    
    @RequestMapping("/register")
    public int register(User user){
        //TODO:用户注册时创建一个对象
        return 0;
    }
}
