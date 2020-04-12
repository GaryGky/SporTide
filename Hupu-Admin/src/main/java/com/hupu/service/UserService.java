package com.hupu.service;

import com.hupu.pojo.User;

import java.util.List;

public interface UserService {
    
    public int createUser(int id, String email, String pwd, String nikeName, String createTime); // 用户创建
    
    public int deleteUserById(int id); // 销毁一个用户
    
    public int updateUserName(int id, String newName); // 更改昵称
    
    public int updateUserPwd(int id, String oldPwd, String newPwd); // 更新密码
    
    public int updateUserStatus(int id, int status); // 更新用户状态
    
    public User queryUserById(int id);
    
    public List<User> queryUserByName(String userName);
    
    public User queryUserByEmail(String email);
    
    public String queryUserPwdById(int id);
    
    public List<User> queryAllUser();
}
