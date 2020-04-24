package com.hupu.pojo;

import java.io.Serializable;

public class User implements Serializable {
    private Integer userId;
    
    private String userEmail;
    
    private String userPassword;
    
    private String userNikename;
    //注册时间 
    private String userTime;
    //默认0 
    private Integer userStatus;
    
    private String userName;
    
    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userEmail='" + userEmail + '\'' +
                ", userPassword=" + userPassword +
                ", userNikename='" + userNikename + '\'' +
                ", userTime='" + userTime + '\'' +
                ", userStatus=" + userStatus +
                ", userName='" + userName + '\'' +
                '}';
    }
    
    public User() {
    }
    
    public User(Integer userId, String userName, String userEmail,
                String userPassword, String userNikename, String userTime, Integer userStatus) {
        this.userId = userId;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userNikename = userNikename;
        this.userTime = userTime;
        this.userStatus = userStatus;
        this.userName = userName;
    }
    
    public Integer getUserId() {
        return userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    
    public String getUserEmail() {
        return userEmail;
    }
    
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    
    public Object getUserPassword() {
        return userPassword;
    }
    
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    
    public String getUserNikename() {
        return userNikename;
    }
    
    public void setUserNikename(String userNikename) {
        this.userNikename = userNikename;
    }
    
    public String getUserTime() {
        return userTime;
    }
    
    public void setUserTime(String userTime) {
        this.userTime = userTime;
    }
    
    public Integer getUserStatus() {
        return userStatus;
    }
    
    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
}