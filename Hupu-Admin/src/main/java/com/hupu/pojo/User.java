package com.hupu.pojo;

public class User {
    private int user_id;
    private String user_email;
    private String user_password;
    private String user_nikeName;
    private String user_time;
    private int user_status; // 标识用户的状态
    
    public User(int id, String email, String pwd, String nikeName, String createTime, int status) {
        this.user_id = id;
        this.user_email = email;
        this.user_password = pwd;
        this.user_nikeName = nikeName;
        this.user_time = createTime;
        this.user_status = status;
    }
    
    public User() {
    }
    
    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_email='" + user_email + '\'' +
                ", user_password='" + user_password + '\'' +
                ", user_nikeName='" + user_nikeName + '\'' +
                ", user_time='" + user_time + '\'' +
                ", user_status=" + user_status +
                '}';
    }
    
    public int getUser_id() {
        return user_id;
    }
    
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    
    public String getUser_email() {
        return user_email;
    }
    
    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }
    
    public String getUser_password() {
        return user_password;
    }
    
    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }
    
    public String getUser_nikeName() {
        return user_nikeName;
    }
    
    public void setUser_nikeName(String user_nikeName) {
        this.user_nikeName = user_nikeName;
    }
    
    public String getUser_time() {
        return user_time;
    }
    
    public void setUser_time(String user_time) {
        this.user_time = user_time;
    }
    
    public int getUser_status() {
        return user_status;
    }
    
    public void setUser_status(int user_status) {
        this.user_status = user_status;
    }
}
