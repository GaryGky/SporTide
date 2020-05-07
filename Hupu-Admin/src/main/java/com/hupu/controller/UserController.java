package com.hupu.controller;

import com.hupu.pojo.User;
import com.hupu.service.Impl.AdminServiceImpl;
import com.hupu.service.Impl.UserServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    @Qualifier("adminServiceImpl")
    private AdminServiceImpl adminService;
    
    @Autowired
    @Qualifier("userService")
    private UserServiceImpl userService;
    
    @RequestMapping("/getLimitUser")
    public String getLimitUser(HttpServletRequest request) {
        System.out.println("获取用户");
        ArrayList<User> users = new ArrayList<>(userService.queryAllByLimit(0
                , 100));
        request.getSession().setAttribute("userMap", users);
        return "Success";
    }
    
    
    @RequestMapping("/addAdmin")
    public int addAdmin(String name, String pwd1) {
        return adminService.createAdmin(name, pwd1);
    }
    
    @RequestMapping("/delUser") // 删除用户
    public String delUser(int id, HttpServletRequest request) {
        String delMsg = "";
        System.out.println("进入删除用户: id ===> " + id);
        int res = userService.deleteById(id);
        delMsg = res == 1 ? "success" : "fail";// 返回一表示成功删除了用户
        ArrayList<User> users = new ArrayList<>(userService.queryAllByLimit(0
                , 100));
        request.getSession().setAttribute("userMap", users); // 重新设置model
        return delMsg;
    }
    
    @RequestMapping("/updateUser")
    public int updateUser(User user){
        return userService.update(user);
    }
}
