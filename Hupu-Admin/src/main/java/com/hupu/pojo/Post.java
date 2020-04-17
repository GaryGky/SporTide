package com.hupu.pojo;

public class Post {
    private int post_id;
    private String post_type;
    private String post_info;
    private String post_time;
    private int post_collectNum;
    private int post_commentNum;
    private int post_readNum;
    private int user_id;
    
    public Post() {
    
    }
    
    public Post(int post_id, String post_type, String post_info, String post_time, int post_collectNum, int post_commentNum, int post_readNum, int user_id) {
        this.post_id = post_id;
        this.post_type = post_type;
        this.post_info = post_info;
        this.post_time = post_time;
        this.post_collectNum = post_collectNum;
        this.post_commentNum = post_commentNum;
        this.post_readNum = post_readNum;
        this.user_id = user_id;
    }
    
    @Override
    public String toString() {
        return "Post{" +
                "post_id=" + post_id +
                ", post_type='" + post_type + '\'' +
                ", post_info='" + post_info + '\'' +
                ", post_time='" + post_time + '\'' +
                ", post_collectNum=" + post_collectNum +
                ", post_commentNum=" + post_commentNum +
                ", post_readNum=" + post_readNum +
                ", user_id=" + user_id +
                '}';
    }
    
    public int getPost_id() {
        return post_id;
    }
    
    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }
    
    public String getPost_type() {
        return post_type;
    }
    
    public void setPost_type(String post_type) {
        this.post_type = post_type;
    }
    
    public String getPost_info() {
        return post_info;
    }
    
    public void setPost_info(String post_info) {
        this.post_info = post_info;
    }
    
    public String getPost_time() {
        return post_time;
    }
    
    public void setPost_time(String post_time) {
        this.post_time = post_time;
    }
    
    public int getPost_collectNum() {
        return post_collectNum;
    }
    
    public void setPost_collectNum(int post_collectNum) {
        this.post_collectNum = post_collectNum;
    }
    
    public int getPost_commentNum() {
        return post_commentNum;
    }
    
    public void setPost_commentNum(int post_commentNum) {
        this.post_commentNum = post_commentNum;
    }
    
    public int getPost_transpondNum() {
        return post_readNum;
    }
    
    public void setPost_transpondNum(int post_readNum) {
        this.post_readNum = post_readNum;
    }
    
    public int getUser_id() {
        return user_id;
    }
    
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
