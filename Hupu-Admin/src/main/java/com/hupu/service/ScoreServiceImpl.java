package com.hupu.service;

import com.hupu.dao.ScoreMapper;
import com.hupu.pojo.Score;

import java.util.List;

public class ScoreServiceImpl implements ScoreService {
    private ScoreMapper scoreMapper;
    
    public ScoreServiceImpl() {
    }
    
    public ScoreServiceImpl(ScoreMapper scoreMapper) {
        this.scoreMapper = scoreMapper;
    }
    
    public ScoreMapper getScoreMapper() {
        return scoreMapper;
    }
    
    public void setScoreMapper(ScoreMapper scoreMapper) {
        this.scoreMapper = scoreMapper;
    }
    
    public void insertScore(Score score) {
        this.scoreMapper.insertScore(score);
    }
    
    public List<Score> queryScoreByTeam(String team) {
        return this.scoreMapper.queryScoreByTeam(team);
    }
    
    public List<Score> queryScoreByDate(String date) {
        return this.scoreMapper.queryScoreByDate(date);
    }
}
