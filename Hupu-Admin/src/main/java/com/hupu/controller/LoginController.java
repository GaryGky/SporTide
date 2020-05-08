package com.hupu.controller;

import com.alibaba.fastjson.JSON;
import com.hupu.pojo.User;
import com.hupu.service.Impl.AdminServiceImpl;
import com.hupu.service.Impl.UserServiceImpl;
import com.hupu.utils.DateUtils;
import com.hupu.utils.UserIdGen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    @Qualifier("adminServiceImpl")
    private AdminServiceImpl adminService;
    
    @Autowired
    @Qualifier("userService")
    private UserServiceImpl userService;
    
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
    
    @RequestMapping(value = "/register", method = {RequestMethod.POST})
    public int register(@RequestBody User user) { // 创建一个用户
        System.out.println(user);
        return userService.insert(user);
    }
    
    @RequestMapping(value = "/register-web", method = {RequestMethod.POST})
    public int register_web(@RequestParam Map map) { // 创建一个用户
        System.out.println(JSON.toJSON(map));
        User user = new User((int) UserIdGen.get().nextId(), (String) map.get(
                "name"),
                (String) map.get("email"),
                (String) map.get(
                        "password"),
                (String) map.get("nikeName"), DateUtils.getCurTime(), 0);
        return userService.insert(user);
    }
}
