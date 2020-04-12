package com.hupu.service;

import com.hupu.dao.UserMapper;
import com.hupu.pojo.User;

import java.util.List;

public class UserSeriveImpl implements UserService {
    private UserMapper userMapper;
    private final int ErrorCodeForPwd = -1; // 定义错误编码
    
    public int createUser(int id, String email, String pwd, String nikeName, String createTime) {
        return userMapper.createUser(id, email, pwd, nikeName, createTime);
    }
    
    public int deleteUserById(int id) {
        return userMapper.deleteUserById(id);
    }
    
    public int updateUserName(int id, String newName) {
        return userMapper.updateUserName(id, newName);
    }
    
    public int updateUserPwd(int id, String oldPwd, String newPwd) {
        // 如果旧密码验证成功,则允许修改密码,否则无法修改
        if (oldPwd.equals(userMapper.queryUserPwdById(id))) {
            return userMapper.updateUserPwd(id, newPwd);
        } else {
            return ErrorCodeForPwd;
        }
    }
    
    public int updateUserStatus(int id, int status) {
        return userMapper.updateUserStatus(id, status);
    }
    
    public User queryUserById(int id) {
        return userMapper.queryUserById(id);
    }
    
    public List<User> queryUserByName(String userName) {
        return userMapper.queryUserByName(userName);
    }
    
    public User queryUserByEmail(String email) {
        return userMapper.queryUserByEmail(email);
    }
    
    public String queryUserPwdById(int id) {
        return userMapper.queryUserPwdById(id);
    }
    
    public List<User> queryAllUser() {
        return userMapper.queryAllUser();
    }
    
    public UserMapper getUserMapper() {
        return userMapper;
    }
    
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    
    public int getErrorCodeForPwd() {
        return ErrorCodeForPwd;
    }
}
