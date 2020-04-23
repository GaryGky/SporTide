package com.hupu.dao;

import com.hupu.pojo.User;
import com.hupu.service.Impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {
    private UserServiceImpl userService;
    
    @Before
    public void before() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "application-context.xml");
        userService = (UserServiceImpl) context.getBean("userService");
    }
    
    @Test
    public void testInsert() {
        System.out.println("====Test Insert=====");
        userService.insert(new User(1, "user_name", "email", "pwd1", "nike1",
                "time1", 1));
        userService.insert(new User(2, "user_name2", "email", "pwd1", "nike1",
                "time1", 1));
        userService.insert(new User(3, "user_name3", "email", "pwd1", "nike1",
                "time1", 1));
        userService.insert(new User(4, "user_name4", "email", "pwd1", "nike1",
                "time1", 1));
        userService.insert(new User(5, "user_name5", "email", "pwd1", "nike1",
                "time1", 1));
        userService.insert(new User(6, "user_name6", "email", "pwd1", "nike1",
                "time1", 1));
        userService.insert(new User(7, "user_name7", "email", "pwd1", "nike1",
                "time1", 1));
        userService.insert(new User(8, "user_name8", "email", "pwd1", "nike1",
                "time1", 1));
        userService.insert(new User(9, "user_name9", "email", "pwd1", "nike1"
                , "time1", 1));
        userService.insert(new User(10, "user_name10", "email", "pwd1", "nike1",
                "time1", 1));
        userService.insert(new User(11, "user_name11", "email", "pwd1", "nike1"
                , "time1", 1));
    }
    
    @Test
    public void testQuery(){
        userService.queryAllByLimit(5,10).forEach(System.out::println);
    }
    
    @Test
    public void deleteById(){
        for(int i=0;i<10;i++){
            userService.deleteById(i);
        }
    }
    
}
