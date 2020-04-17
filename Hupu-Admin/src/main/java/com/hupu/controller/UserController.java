package com.hupu.controller;

import com.hupu.pojo.User;
import com.hupu.service.Impl.AdminServiceImpl;
import com.hupu.service.Impl.UserServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    @Qualifier("adminServiceImpl")
    private AdminServiceImpl adminService;
    
    @Autowired
    @Qualifier("userServiceImpl")
    private UserServiceImpl userService;
    
    @RequestMapping("/addAdmin")
    public String addAdmin(String name, String pwd1, String pwd2) {
        System.out.println("name  ===>" + name);
        System.out.println("pwd1  ===>" + pwd1);
        System.out.println("pwd2  ===>" + pwd2);
        if (!pwd1.equals(pwd2)) {
            return "pwd-unmatched";
        } else {
            adminService.createAdmin(name, pwd1);
            return "admin-add";
        }
    }
    
    @RequestMapping("/getMyUser")
    public List<User> getUser() {
        System.out.println("controller 接收user请求");
        return userService.queryAllUser();
    }
}
