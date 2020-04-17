package com.hupu.controller;

import com.hupu.pojo.User;
import com.hupu.service.Impl.AdminServiceImpl;
import com.hupu.service.Impl.UserServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
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
    
    @RequestMapping("/delUser") // 删除用户
    public HashMap<String, Object> delUser(int id) {
        String delMsg = "";
        System.out.println("进入删除用户: id ===> " + id);
        int res = userService.deleteUserById(id);
        if (res == 1) { // 返回一表示成功删除了用户
            delMsg = "success";
        } else {
            delMsg = "fail";
        }
        HashMap<String, Object> map = new HashMap<>(); // ajax请求通过map返回结果
        map.put("delMsg", delMsg);
        map.put("UserList", userService.queryAllUser());
        return map;
    }
}
