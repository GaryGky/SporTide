package com.hupu.dao;

import java.util.List;

public interface Admin {
    public int createAdmin(int id, String name, String pwd);// 创建一个管理员
    
    public int updateAdminPwd(int id, String oldPwd, String newPwd); // 更新管理员密码
    
    public int updateAdminName(int id, String newName); // 更新管理员名称
    
    public List<Admin> queryAllAdmins(); // 查看所有管理员
    
    public int deleteAdminById(int id); // 删除一个管理员
}
