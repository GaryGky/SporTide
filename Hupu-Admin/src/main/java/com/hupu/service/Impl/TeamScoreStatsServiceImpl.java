package com.hupu.service.Impl;


import com.hupu.dao.TeamScoreStatsDao;
import com.hupu.pojo.Team;
import com.hupu.pojo.TeamScoreStats;
import com.hupu.service.TeamScoreStatsService;
import com.hupu.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    
    @Autowired
    @Qualifier("redisUtil")
    private RedisUtil redisUtil;
    
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
    
    // TODO:这里定义为切入点
    // TODO: 加一个切面，设置访问数据库之前先访问redis缓存
    @Override
    public List<TeamScoreStats> getTeamStatsByGameId(int gameId) {
        String key = gameId + "teamStats";
        if (redisUtil.get(key) != null) { // 如果缓存存在则从缓存中取得
            return (List<TeamScoreStats>) redisUtil.get(key);
        } else { // 否则从数据库中get并且刷新缓存
            List<TeamScoreStats> list =
                    teamScoreStatsDao.getTeamStatsByGameId(gameId);
            redisUtil.set(key, list);
            return list;
        }
    }
    
    // TODO:添加缓存
    @Override
    public ArrayList<Map> getGameIndexByDay(String date) throws ParseException {
        SimpleDateFormat myFmt = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
        SimpleDateFormat format = new SimpleDateFormat("%yyyy%MM%dd%");
        String queryDay = format.format(myFmt.parse(date));
        List<TeamScoreStats> gameIndexByDay = null;
        String key = queryDay+ "day";
        if(redisUtil.get(key) != null){
            // TODO: 有没有办法可以保证转换合法?
            gameIndexByDay = (List<TeamScoreStats>) redisUtil.get(key);
            
        }else {
            gameIndexByDay =
                    teamScoreStatsDao.getGameIndex(queryDay);
            redisUtil.set(key,gameIndexByDay,1800); //30分钟过期
        }
        ArrayList<Map> maps = new ArrayList<>();
        for (int i = 0; i < gameIndexByDay.size(); i++) {
            HashMap<String, Object> gameMap = new HashMap<>();
            gameMap.put("awayTeam", gameIndexByDay.get(i).getTeamid());
            gameMap.put("awayScore", gameIndexByDay.get(i).getScore());
            gameMap.put("homeTeam", gameIndexByDay.get(i + 1).getTeamid());
            gameMap.put("homeScore", gameIndexByDay.get(i + 1).getScore());
            i++;
            maps.add(gameMap);
        }
        return maps;
    }
    
    // TODO:添加缓存
    @Override
    public HashMap<String, Object> getScoreByGame(int gameId) { // 获得比赛的得分数据
        String key = gameId + "gameScore";
        HashMap<String, Object> map = new HashMap<>();
        if(redisUtil.get(key) != null){
            return (HashMap<String, Object>) redisUtil.get(key);
        }else {
            for (TeamScoreStats teamScore :
                    teamScoreStatsDao.getTeamStatsByGameId(gameId)) {
                if (teamScore.getIshome() == 0) {
                    map.put("away", teamScore);
                } else {
                    map.put("home", teamScore);
                }
            }
            redisUtil.set("key",map,900); // 15分钟过期
            return map;
        }
        
    }
}