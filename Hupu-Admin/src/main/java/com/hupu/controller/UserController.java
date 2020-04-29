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
    public String getLimitUser(HttpServletRequest request,
                               HttpServletResponse response) {
        System.out.println("获取用户");
        if (request.getSession().getAttribute("userMap") != null) {
            return "Exist";
        }
        int entries = 100;
        ArrayList<User> users = new ArrayList<>();
        users.addAll(userService.queryAllByLimit(0,entries));
        request.getSession().setAttribute("userMap", users);
        return "Success";
    }
    
    
    @RequestMapping("/addAdmin")
    public int addAdmin(String name, String pwd1, String pwd2) {
        System.out.println("name  ===>" + name);
        System.out.println("pwd1  ===>" + pwd1);
        System.out.println("pwd2  ===>" + pwd2);
        if (!pwd1.equals(pwd2)) {
            return 0;
        } else {
            adminService.createAdmin(name, pwd1);
            return 1;
        }
    }
    
    @RequestMapping("/delUser") // 删除用户
    public HashMap<String, Object> delUser(int id) {
        String delMsg = "";
        System.out.println("进入删除用户: id ===> " + id);
        int res = userService.deleteById(id);
        if (res == 1) { // 返回一表示成功删除了用户
            delMsg = "success";
        } else {
            delMsg = "fail";
        }
        HashMap<String, Object> map = new HashMap<>(); // ajax请求通过map返回结果
        map.put("delMsg", delMsg);
        map.put("UserList", userService.queryAllByLimit(0, 10));
        return map;
    }
}
