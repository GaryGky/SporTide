package com.hupu.dao;

import com.hupu.pojo.Admin;
import com.hupu.service.AdminService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminMapper {
    public int createAdmin(@Param("admin_id") int id,
                           @Param("name") String name,
                           @Param("pwd") String pwd);//
    // 创建一个管理员
    
    public int updateAdminPwd(@Param("admin_id") int id,
                              @Param("newPwd") String newPwd); // 更新管理员密码
    
    public int updateAdminName(@Param("admin_id") int id,
                               @Param("newName") String newName); // 更新管理员名称
    
    public List<Admin> queryAllAdmins(); // 查看所有管理员
    
    public String queryAdminPwdById(@Param("admin_id") int id);
    
    public Admin queryAdminById(@Param("admin_id") int id);
    
    public int deleteAdminById(@Param("admin_id") int id); // 删除一个管理员
}
