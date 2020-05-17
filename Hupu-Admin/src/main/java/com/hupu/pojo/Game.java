package com.hupu.pojo;

import java.io.Serializable;

public class Game implements Serializable {
    
    private Integer gameid;
    private String gametime;
    private String consumtime;
    private String arena;
    private String peoplenum;
    
    public Game() {
    }
    
    @Override
    public String toString() {
        return "Game{" +
                "gameid=" + gameid +
                ", gametime='" + gametime + '\'' +
                ", consumtime='" + consumtime + '\'' +
                ", arena='" + arena + '\'' +
                ", peoplenum='" + peoplenum + '\'' +
                '}';
    }
    
    public Game(Integer gameid, String gametime, String consumtime, String arena, String peoplenum) {
        this.gameid = gameid;
        this.gametime = gametime;
        this.consumtime = consumtime;
        this.arena = arena;
        this.peoplenum = peoplenum;
    }
    
    public Integer getGameid() {
        return gameid;
    }
    
    public void setGameid(Integer gameid) {
        this.gameid = gameid;
    }
    
    public String getGametime() {
        return gametime;
    }
    
    public void setGametime(String gametime) {
        this.gametime = gametime;
    }
    
    public String getConsumtime() {
        return consumtime;
    }
    
    public void setConsumtime(String consumtime) {
        this.consumtime = consumtime;
    }
    
    public String getArena() {
        return arena;
    }
    
    public void setArena(String arena) {
        this.arena = arena;
    }
    
    public String getPeoplenum() {
        return peoplenum;
    }
    
    public void setPeoplenum(String peoplenum) {
        this.peoplenum = peoplenum;
    }
    
}