package com.hupu.service.Impl;


import com.hupu.config.HupuEnum;
import com.hupu.dao.PlayerScoreStatsDao;
import com.hupu.pojo.PlayerScoreStats;
import com.hupu.pojo.TeamScoreStats;
import com.hupu.service.PlayerScoreStatsService;
import com.hupu.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    
    @Autowired
    @Qualifier("redisUtil")
    private RedisUtil redisUtil;
    
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
    
    @Override
    public List<PlayerScoreStats> queryByGameId(int gameId) {
        return playerScoreStatsDao.queryByGameId(gameId);
    }
    
    public HashMap<String, Object> getMap(List<PlayerScoreStats> playerList) {
        int score = 0; // 得分
        int court = 0; // 篮板可以由前场后场篮板相加得到
        int assist = 0;
        int steal = 0;
        int block = 0;
        int frontCourt = 0;
        int backCourt = 0;
        int shot = 0; // 出手
        int goal = 0; // 命中
        String team = "";
        HashMap<String, Object> teamStatsMap = new HashMap<>();
        for (PlayerScoreStats playerStats : playerList) {
            score += playerStats.getScore();
            backCourt += playerStats.getBackcourt();
            frontCourt += playerStats.getFrontcourt();
            assist += playerStats.getAssist();
            steal += playerStats.getSteal();
            block += playerStats.getBlock();
            Pattern pattern = Pattern.compile("(\\d+)-(\\d+)");
            Matcher matcher = pattern.matcher(playerStats.getShot());
            if (matcher.matches()) {
                goal += Integer.parseInt(matcher.group(1));
                shot += Integer.parseInt(matcher.group(2));
            }
            team = playerStats.getTeamid();
            court = backCourt + frontCourt; // 篮板
            String hitRate = goal + "-" + shot; // 命中率
            teamStatsMap.put("score", score);
            teamStatsMap.put("court", court);
            teamStatsMap.put("assist", assist);
            teamStatsMap.put("steal", steal);
            teamStatsMap.put("block", block);
            teamStatsMap.put("frontCourt", frontCourt);
            teamStatsMap.put("backCourt", backCourt);
            teamStatsMap.put("hitRate", hitRate);
            teamStatsMap.put("team", team);
        }
        return teamStatsMap;
    }
    
    // 获得一场比赛的球队统计数据
    @Override
    public HashMap<String, Object> getTeamStatsByGame(int gameId) {
        String key = gameId + "teamScoreStats";
        if (redisUtil.get(key) != null) {
            return (HashMap<String, Object>) redisUtil.get(key);
        }
        HashMap<String, Object> gameMap = new HashMap<>();
        List<PlayerScoreStats> listHome = new ArrayList<>();
        List<PlayerScoreStats> listAway = new ArrayList<>();
        for (PlayerScoreStats stats : playerScoreStatsDao.queryByGameId(gameId)) {
            if (stats.getTeamstatsid() % 10 == 0) {
                listAway.add(stats);
            } else {
                listHome.add(stats);
            }
        }
        gameMap.put("home", getMap(listHome));
        gameMap.put("away", getMap(listAway));
        redisUtil.set(key, gameMap, HupuEnum.RedisExpTime.SHORT_TIME.getTime());
        return gameMap;
    }
    
    @Override
    public HashMap<String, Object> getPlayerStatsByGame(int gameId) {
        String key = gameId + "player";
        if (redisUtil.get(key) != null) {
            return (HashMap<String, Object>) redisUtil.get(key);
        }
        HashMap<String, Object> gameMap = new HashMap<>();
        // 查询一次数据库
        ArrayList<PlayerScoreStats> awayList = new ArrayList<>();
        ArrayList<PlayerScoreStats> homeList = new ArrayList<>();
        for (PlayerScoreStats playerStats :
                playerScoreStatsDao.queryByGameId(gameId)) {
            if (playerStats.getTeamstatsid() % 10 == 0) {
                awayList.add(playerStats);
            } else {
                homeList.add(playerStats);
            }
        }
        gameMap.put("home", homeList);
        gameMap.put("away", awayList);
        redisUtil.set(key, gameMap, HupuEnum.RedisExpTime.SHORT_TIME.getTime());
        return gameMap;
    }
}