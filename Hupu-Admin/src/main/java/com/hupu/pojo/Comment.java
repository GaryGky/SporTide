package com.hupu.pojo;

public class Comment {
    private int id;
    private String info;
    private String status;
    private String time;
    private int post_id;
    private int from_uid;
    private int to_uid;
    
    public Comment() {
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
    
    public int getFrom_uid() {
        return from_uid;
    }
    
    public void setFrom_uid(int from_uid) {
        this.from_uid = from_uid;
    }
    
    public int getTo_uid() {
        return to_uid;
    }
    
    public void setTo_uid(int to_uid) {
        this.to_uid = to_uid;
    }
    
    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", info='" + info + '\'' +
                ", status='" + status + '\'' +
                ", time='" + time + '\'' +
                ", post_id=" + post_id +
                ", from_uid=" + from_uid +
                ", to_uid=" + to_uid +
                '}';
    }
    
    public Comment(int id, String info, String status, String time, int post_id, int from_uid, int to_uid) {
        this.id = id;
        this.info = info;
        this.status = status;
        this.time = time;
        this.post_id = post_id;
        this.from_uid = from_uid;
        this.to_uid = to_uid;
    }
    
    
}
