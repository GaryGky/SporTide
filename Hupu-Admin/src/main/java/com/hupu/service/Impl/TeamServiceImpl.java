package com.hupu.service.Impl;


import com.hupu.dao.TeamDao;
import com.hupu.pojo.Team;
import com.hupu.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * (Team)表服务实现类
 *
 * @author makejava
 * @since 2020-04-23 19:30:38
 */
@Service("teamService")
@Transactional
public class TeamServiceImpl implements TeamService {
    
    @Autowired
    @Qualifier("teamDao")
    private TeamDao teamDao;
    
    @Override
    public Team queryById(String teamid) {
        return teamDao.queryById(teamid);
    }
    
    @Override
    public List<Team> queryAllByLimit(int offset, int limit) {
        return teamDao.queryAllByLimit(offset, limit);
    }
    
    @Override
    public List<Team> queryAll(Team team) {
        return teamDao.queryAll(team);
    }
    
    @Override
    public int insert(Team team) {
        return teamDao.insert(team);
    }
    
    @Override
    public int update(Team team) {
        return teamDao.update(team);
    }
    
    @Override
    public int deleteById(String teamid) {
        return teamDao.deleteById(teamid);
    }
}