package com.hupu.service.Impl;


import com.hupu.dao.PlayerScoreStatsDao;
import com.hupu.pojo.PlayerScoreStats;
import com.hupu.service.PlayerScoreStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * (PlayerScoreStats)表服务实现类
 *
 * @author makejava
 * @since 2020-04-23 20:11:25
 */
@Service("playerScoreStatsService")
@Transactional
public class PlayerScoreStatsServiceImpl implements PlayerScoreStatsService {
    
    @Autowired
    @Qualifier("playerScoreStatsDao")
    private PlayerScoreStatsDao playerScoreStatsDao;
    
    @Override
    public PlayerScoreStats queryById(Integer id) {
        return playerScoreStatsDao.queryById(id);
    }
    
    @Override
    public List<PlayerScoreStats> queryAllByLimit(int offset, int limit) {
        return playerScoreStatsDao.queryAllByLimit(offset, limit);
    }
    
    @Override
    public List<PlayerScoreStats> queryAll(PlayerScoreStats playerScoreStats) {
        return playerScoreStatsDao.queryAll(playerScoreStats);
    }
    
    @Override
    public int insert(PlayerScoreStats playerScoreStats) {
        return playerScoreStatsDao.insert(playerScoreStats);
    }
    
    @Override
    public int update(PlayerScoreStats playerScoreStats) {
        return playerScoreStatsDao.update(playerScoreStats);
    }
    
    @Override
    public int deleteById(Integer id) {
        return playerScoreStatsDao.deleteById(id);
    }
    
    @Override
    public List<PlayerScoreStats> queryByTeamStatsId(int teamStatsId) {
        return playerScoreStatsDao.queryByTeamStatsId(teamStatsId);
    }
}