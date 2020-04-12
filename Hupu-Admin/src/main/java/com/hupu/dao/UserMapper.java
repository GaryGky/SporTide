package com.hupu.dao;

import com.hupu.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    public int createUser(@Param("id") int id,
                          @Param("email") String email,
                          @Param("pwd") String pwd,
                          @Param("nikeName") String nikeName,
                          @Param("createTime") String createTime); // 用户创建
    
    public int deleteUserById(@Param("id") int id); // 销毁一个用户
    
    
    public int updateUserName(@Param("id") int id,
                              @Param("newName") String newName); // 更改昵称
    
    public int updateUserPwd(@Param("id") int id,
                             @Param("newPwd") String newPwd); // 更新密码
    
    public int updateUserStatus(@Param("id") int id,
                                @Param("status") int status); // 更新用户状态
    
    public User queryUserById(@Param("id") int id);
    
    public List<User> queryUserByName(@Param("name") String userName);
    
    public User queryUserByEmail(@Param("email") String email);
    
    public String queryUserPwdById(@Param("id") int id);
    
    public List<User> queryAllUser();
    
}
