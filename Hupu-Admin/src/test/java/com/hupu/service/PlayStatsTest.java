package com.hupu.service;

import com.alibaba.fastjson.JSON;
import com.hupu.pojo.Game;
import com.hupu.pojo.PlayerScoreStats;
import com.hupu.pojo.TeamScoreStats;
import com.hupu.service.Impl.GameServiceImpl;
import com.hupu.service.Impl.PlayerScoreStatsServiceImpl;
import com.hupu.service.Impl.TeamScoreStatsServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlayStatsTest {
    private PlayerScoreStatsServiceImpl playerScoreStats;
    private TeamScoreStatsServiceImpl teamScoreStatsService;
    private GameServiceImpl gameService;
    
    @Before
    public void before() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "application-context.xml");
        playerScoreStats = (PlayerScoreStatsServiceImpl) context.getBean(
                "playerScoreStatsService");
        teamScoreStatsService = (TeamScoreStatsServiceImpl) context.getBean("teamScoreStatsService");
        gameService = (GameServiceImpl) context.getBean("gameService");
    }
    
    @Test
    public void getTeamStats() {
        int gameId = 156542;
        HashMap<String, Object> gameMap = new HashMap<>();
        for (TeamScoreStats teamScoreStats : teamScoreStatsService.getTeamStatsByGameId(gameId)) {
            HashMap<String, Object> teamStatsMap = new HashMap<>();
            int teamStatsId = teamScoreStats.getId();
            int score = 0; // 得分
            int court = 0; // 篮板可以由前场后场篮板相加得到
            int assist = 0;
            int steal = 0;
            int block = 0;
            int frontCourt = 0;
            int backCourt = 0;
            int shot = 0; // 出手
            int goal = 0; // 命中
            String team = null;
            for (PlayerScoreStats playerStats : playerScoreStats.queryByTeamStatsId(teamStatsId)) {
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
            }
            //TODO: 把球队技术统计放到map中保存
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
            // TODO: 把球队的map添加到game的map中
            if (teamScoreStats.getIshome() == 0) {
                gameMap.put("away", teamStatsMap);
            } else {
                gameMap.put("home", teamStatsMap);
            }
        }
        System.out.println(JSON.toJSON(gameMap));
    }
    
    
    @Test
    public void getPlayerStats() {
        int gameId = 156542;
        HashMap<String, Object> gameMap = new HashMap<>();
        for (TeamScoreStats teamScoreStats : teamScoreStatsService.getTeamStatsByGameId(gameId)) {
            int teamStatsId = teamScoreStats.getId();
            ArrayList<PlayerScoreStats> playerStatsList = new ArrayList<>(playerScoreStats.queryByTeamStatsId(teamStatsId));
            if (teamScoreStats.getIshome() == 0) {
                gameMap.put("away", playerStatsList);
            } else {
                gameMap.put("home", playerStatsList);
            }
        }
        System.out.println(JSON.toJSON(gameMap));
    }
    
    @Test
    public void getTeamScore() {
        int gameId = 156542;
        HashMap<String, Object> map = new HashMap<>();
        for (TeamScoreStats teamScore : teamScoreStatsService.getTeamStatsByGameId(gameId)) {
            if (teamScore.getIshome() == 0) {
                map.put("away", teamScore);
            } else {
                map.put("home", teamScore);
            }
        }
        System.out.println(JSON.toJSON(map));
    }
}
