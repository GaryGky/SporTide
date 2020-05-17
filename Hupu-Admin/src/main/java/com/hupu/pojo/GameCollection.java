package com.hupu.pojo;

import java.io.Serializable;

public class GameCollection implements Serializable {
    
    
    private Integer userId;
    
    private Integer gameId;
    
    private String collectTime;
    
    public GameCollection() {
    }
    
    public GameCollection(Integer userId, Integer gameId, String collectTime) {
        this.userId = userId;
        this.gameId = gameId;
        this.collectTime = collectTime;
    }
    
    public Integer getUserId() {
        return userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    
    public Integer getGameId() {
        return gameId;
    }
    
    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }
    
    public String getCollectTime() {
        return collectTime;
    }
    
    public void setCollectTime(String collectTime) {
        this.collectTime = collectTime;
    }
    
}