package com.hupu.pojo;

public class Post {
    private int id;
    private String type;
    private String info;
    private String createTime;
    private int collectNum;
    private int commentNum;
    private int transpondNum;
    
    public Post() {
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public String getInfo() {
        return info;
    }
    
    public void setInfo(String info) {
        this.info = info;
    }
    
    public String getCreateTime() {
        return createTime;
    }
    
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
    
    public int getCollectNum() {
        return collectNum;
    }
    
    public void setCollectNum(int collectNum) {
        this.collectNum = collectNum;
    }
    
    public int getCommentNum() {
        return commentNum;
    }
    
    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }
    
    public int getTranspondNum() {
        return transpondNum;
    }
    
    public void setTranspondNum(int transpondNum) {
        this.transpondNum = transpondNum;
    }
    
    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", info='" + info + '\'' +
                ", createTime='" + createTime + '\'' +
                ", collectNum=" + collectNum +
                ", commentNum=" + commentNum +
                ", transpondNum=" + transpondNum +
                '}';
    }
    
    public Post(int id, String type, String info, String createTime, int collectNum, int commentNum, int transpondNum) {
        this.id = id;
        this.type = type;
        this.info = info;
        this.createTime = createTime;
        this.collectNum = collectNum;
        this.commentNum = commentNum;
        this.transpondNum = transpondNum;
    }
}
