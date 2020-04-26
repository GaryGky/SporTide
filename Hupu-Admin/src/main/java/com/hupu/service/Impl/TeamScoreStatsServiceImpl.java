package com.hupu.service.Impl;


import com.hupu.dao.TeamScoreStatsDao;
import com.hupu.pojo.TeamScoreStats;
import com.hupu.service.TeamScoreStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (TeamScoreStats)表服务实现类
 *
 * @author makejava
 * @since 2020-04-20 13:40:39
 */
@Service("teamScoreStatsService")
@Transactional
public class TeamScoreStatsServiceImpl implements TeamScoreStatsService {
    @Autowired
    @Qualifier("teamScoreStatsDao")
    private TeamScoreStatsDao teamScoreStatsDao;
    
    @Override
    public TeamScoreStats queryById(Integer id) {
        return teamScoreStatsDao.queryById(id);
    }
    
    @Override
    public List<TeamScoreStats> queryAllByLimit(int offset, int limit) {
        return teamScoreStatsDao.queryAllByLimit(offset, limit);
    }
    
    @Override
    public List<TeamScoreStats> queryAll(TeamScoreStats teamScoreStats) {
        return teamScoreStatsDao.queryAll(teamScoreStats);
    }
    
    @Override
    public int insert(TeamScoreStats teamScoreStats) {
        return teamScoreStatsDao.insert(teamScoreStats);
    }
    
    @Override
    public int update(TeamScoreStats teamScoreStats) {
        return teamScoreStatsDao.update(teamScoreStats);
    }
    
    @Override
    public int deleteById(Integer id) {
        return teamScoreStatsDao.deleteById(id);
    }
    
    @Override
    public List<TeamScoreStats> getTeamStatsByGameId(int gameId) {
        
        return teamScoreStatsDao.getTeamStatsByGameId(gameId);
    }
    
    @Override
    public List<TeamScoreStats> getGameIndexByDay(String date) {
        return teamScoreStatsDao.getGameIndex(date);
    }
}