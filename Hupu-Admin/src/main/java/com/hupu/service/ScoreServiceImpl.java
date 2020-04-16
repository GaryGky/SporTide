package com.hupu.service;

import com.hupu.dao.ScoreMapper;
import com.hupu.pojo.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {
    @Autowired
    @Qualifier("scoreMapper")
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
