package com.hupu.dao;

import com.hupu.pojo.User;
import com.hupu.service.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {
    @Test
    public void testInsert() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "application-context.xml");
        UserServiceImpl userSerive = (UserServiceImpl) context.getBean(
                "userServiceImpl");
        userSerive.createUser(1, "email1", "pwd1", "name1", "time1");
        userSerive.createUser(2, "email2", "pwd2", "name2", "time2");
        userSerive.createUser(3, "email3", "pwd3", "name3", "time3");
    }
    
    
    @Test
    public void testQueryAll() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "application-context.xml");
        UserServiceImpl userSerive = (UserServiceImpl) context.getBean(
                "userServiceImpl");
        System.out.println("====== Test Query All =======");
        for (User user : userSerive.queryAllUser()) {
            System.out.println(user);
        }
        
        System.out.println("======Test Pwd Decipher=======");
        System.out.println(userSerive.queryUserPwdById(1));
        System.out.println(userSerive.queryUserPwdById(2));
        System.out.println(userSerive.queryUserPwdById(3));
        
        System.out.println("===== Test By Email =========");
        System.out.println(userSerive.queryUserByEmail("email1"));
        System.out.println(userSerive.queryUserByEmail("email2"));
        System.out.println(userSerive.queryUserByEmail("email3"));
        
        System.out.println("==== Test By Name =====");
        for (User user : userSerive.queryUserByName("name")) {
            System.out.println(user);
        }
        
        System.out.println("====Test Update User Stauts ======");
        userSerive.updateUserStatus(1, 1);
        userSerive.updateUserStatus(2, 1);
        userSerive.updateUserStatus(3, 1);
        
        System.out.println("==== Test Update User Pwd =====");
        System.out.println(userSerive.updateUserPwd(1, "pwd1", "pwd11"));
        System.out.println(userSerive.updateUserPwd(1, "pwd2", "pwd11"));
        System.out.println(userSerive.updateUserPwd(2, "pwd2", "pwd22"));
        
        System.out.println("===== Test Update User Name ======");
        System.out.println(userSerive.updateUserName(1, "name11"));
        System.out.println(userSerive.updateUserName(2, "name22"));
        System.out.println(userSerive.updateUserName(3, "name33"));
    }
    
    @Test
    public void testDelete() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "application-context.xml");
        UserServiceImpl userSerive = (UserServiceImpl) context.getBean(
                "userServiceImpl");
        System.out.println("==== Test Delete By Id ===== ");
        System.out.println(userSerive.deleteUserById(1));
        System.out.println(userSerive.deleteUserById(2));
        System.out.println(userSerive.deleteUserById(3));
    }
    
}
