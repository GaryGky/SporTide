package com.hupu.pojo;

public class FutureGames {
    private String home;
    
    private String away;
    
    private String gametime;
    
    private Double homeWinRate;
    
    private Double awayWinRate;
    
    
    public String getHome() {
        return home;
    }
    
    public void setHome(String home) {
        this.home = home;
    }
    
    public String getAway() {
        return away;
    }
    
    public void setAway(String away) {
        this.away = away;
    }
    
    public String getGametime() {
        return gametime;
    }
    
    public void setGametime(String gametime) {
        this.gametime = gametime;
    }
    
    public Double getHomeWinRate() {
        return homeWinRate;
    }
    
    public void setHomeWinRate(Double homeWinRate) {
        this.homeWinRate = homeWinRate;
    }
    
    public Double getAwayWinRate() {
        return awayWinRate;
    }
    
    public void setAwayWinRate(Double awayWinRate) {
        this.awayWinRate = awayWinRate;
    }
    
    @Override
    public String toString() {
        return "FutureGames{" +
                "home='" + home + '\'' +
                ", away='" + away + '\'' +
                ", gametime='" + gametime + '\'' +
                ", homeWinRate=" + homeWinRate +
                ", awayWinRate=" + awayWinRate +
                '}';
    }
}