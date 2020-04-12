package com.hupu.dao;

import com.hupu.pojo.Admin;
import com.hupu.service.AdminServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AdminTest {
    @Test
    public void testInsert() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "application-context.xml");
        AdminServiceImpl adminService = (AdminServiceImpl) context.getBean("AdminServiceImpl");
        System.out.println("====== Test Add Admin ====== ");
        adminService.createAdmin(1, "admin1", "admin1");
        adminService.createAdmin(2, "admin2", "admin2");
        adminService.createAdmin(3, "admin3", "admin3");
    }
    
    @Test
    public void testQuery() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "application-context.xml");
        AdminServiceImpl adminService = (AdminServiceImpl) context.getBean("AdminServiceImpl");
        System.out.println("====== Test Query BY ID ====== ");
        System.out.println(adminService.queryAdminById(1));
        System.out.println(adminService.queryAdminById(3));
        System.out.println(adminService.queryAdminById(3));
        
        System.out.println("====== Test Query ALL Admin======");
        for (Admin admin : adminService.queryAllAdmins()) {
            System.out.println(admin);
        }
        
        System.out.println("===== Test Query Pwd=======");
        System.out.println(adminService.queryAdminPwdById(1));
        System.out.println(adminService.queryAdminPwdById(2));
        System.out.println(adminService.queryAdminPwdById(3));
        
        System.out.println("===== Test Update Pwd=======");
        System.out.println(adminService.updateAdminPwd(1, "admin1", "1admin"));
        System.out.println(adminService.updateAdminPwd(1, "admin1", "1admin"));
        System.out.println(adminService.updateAdminPwd(2, "admin2", "2admin"));
        
        System.out.println("===== Test Update Name ===== ");
        System.out.println(adminService.updateAdminName(1, "ad1"));
        System.out.println(adminService.updateAdminName(2, "ad2"));
        System.out.println(adminService.updateAdminName(3, "ad3"));
    }
    
    @Test
    public void testDelete() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "application-context.xml");
        AdminServiceImpl adminService = (AdminServiceImpl) context.getBean("AdminServiceImpl");
        System.out.println("====== Test Delete Admin ====== ");
        System.out.println(adminService.deleteAdminById(1));
        System.out.println(adminService.deleteAdminById(2));
        System.out.println(adminService.deleteAdminById(3));
    }
}
