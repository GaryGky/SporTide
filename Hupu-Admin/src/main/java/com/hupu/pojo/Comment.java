package com.hupu.pojo;

public class Comment {
    private int id;
    private String info;
    private String status;
    private String time;
    private int post_id;
    private int user_id;
    
    public Comment() {
    }
    
    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", info='" + info + '\'' +
                ", status='" + status + '\'' +
                ", time='" + time + '\'' +
                ", post_id=" + post_id +
                ", user_id=" + user_id +
                '}';
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getInfo() {
        return info;
    }
    
    public void setInfo(String info) {
        this.info = info;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getTime() {
        return time;
    }
    
    public void setTime(String time) {
        this.time = time;
    }
    
    public int getPost_id() {
        return post_id;
    }
    
    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }
    
    public int getUser_id() {
        return user_id;
    }
    
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    
    public Comment(int id, String info, String status, String time, int post_id, int user_id) {
        this.id = id;
        this.info = info;
        this.status = status;
        this.time = time;
        this.post_id = post_id;
        this.user_id = user_id;
    }
}
