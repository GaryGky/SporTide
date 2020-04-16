package com.hupu.pojo;

public class Post {
    private int post_id;
    private String post_type;
    private String post_info;
    private String post_Time;
    private int post_collectNum;
    private int post_commentNum;
    private int post_transpondNum;
    
    public Post() {
    }
    
    @Override
    public String toString() {
        return "Post{" +
                "post_id=" + post_id +
                ", post_type='" + post_type + '\'' +
                ", post_info='" + post_info + '\'' +
                ", post_Time='" + post_Time + '\'' +
                ", post_collectNum=" + post_collectNum +
                ", post_commentNum=" + post_commentNum +
                ", post_transpondNum=" + post_transpondNum +
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
    
    public String getPost_Time() {
        return post_Time;
    }
    
    public void setPost_Time(String post_Time) {
        this.post_Time = post_Time;
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
        return post_transpondNum;
    }
    
    public void setPost_transpondNum(int post_transpondNum) {
        this.post_transpondNum = post_transpondNum;
    }
    
    public Post(int post_id, String post_type, String post_info, String post_Time, int post_collectNum, int post_commentNum, int post_transpondNum) {
        this.post_id = post_id;
        this.post_type = post_type;
        this.post_info = post_info;
        this.post_Time = post_Time;
        this.post_collectNum = post_collectNum;
        this.post_commentNum = post_commentNum;
        this.post_transpondNum = post_transpondNum;
    }
}
