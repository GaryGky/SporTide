package com.hupu.controller;

import com.hupu.pojo.Game;
import com.hupu.pojo.PlayerScoreStats;
import com.hupu.pojo.TeamScoreStats;
import com.hupu.service.Impl.GameServiceImpl;
import com.hupu.service.Impl.PlayerScoreStatsServiceImpl;
import com.hupu.service.Impl.TeamScoreStatsServiceImpl;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/game")
public class GameController {
    @Autowired
    @Qualifier("gameService")
    private GameServiceImpl gameService;
    
    @Autowired
    @Qualifier("teamScoreStatsService")
    private TeamScoreStatsServiceImpl teamScoreStats;
    
    @Autowired
    @Qualifier("playerScoreStatsService")
    private PlayerScoreStatsServiceImpl playerScoreStatsService;
    
    
    @RequestMapping("/getGameByLimit") // 一次性获得比赛的全部信息
    public String getGameByLimit(HttpServletRequest request,
                                 String entries) {
        
        if (request.getAttribute("gameInfo") != null) {
            return "exist";
        }
        int entity = 2000; // 一次性请求全部
        // 由比赛id索引比赛，每个比赛是一个hashmap，由string类型指向不同的信息
        //TODO: 为该方法配置缓存，否则一次访问就要读2000+次mysql.
        ArrayList<HashMap<String, Object>> gameInfo = new ArrayList<>();
        List<Game> gameList = gameService.queryAllByLimit(0, entity);
        for (Game game : gameList) {
            int gameId = game.getGameid();
            // 只有两条信息，一条主队，一条客队
            List<TeamScoreStats> teamScoreStatsList =
                    teamScoreStats.getTeamStatsByGameId(gameId);
            HashMap<String, Object> map = new HashMap<>();
            map.put("date", game.getGametime());
            map.put("home", teamScoreStatsList.get(1).getTeamid());
            map.put("away", teamScoreStatsList.get(0).getTeamid());
            map.put("teamPoints",
                    teamScoreStatsList.get(1).getScore() + " : " + teamScoreStatsList.get(0).getScore());
            map.put("arena", game.getArena());
            map.put("audNum", game.getPeoplenum());
            
            gameInfo.add(map);
        }
        request.getSession().setAttribute("gameInfo", gameInfo);
        return "Success";
    }
    
    @RequestMapping("/getScoreByGame") // 获得一场比赛的双方得分数据
    public HashMap<String, Object> getScoreByGame(int gameId) {
        return teamScoreStats.getScoreByGame(gameId);
    }
    
    
    @RequestMapping("/getPlayerByGame") // 获得一场比赛的球员数据
    public HashMap<String, Object> getPlayerStatsByGame(int gameId) {
        return playerScoreStatsService.getPlayerStatsByGame(gameId);
    }
    
    @RequestMapping("/getTeamScoreByGame") // 获得一场比赛的球队统计数据
    public HashMap<String, Object> getTeamStatsByGame(int gameId) {
        return playerScoreStatsService.getTeamStatsByGame(gameId);
    }
    
    @RequestMapping("/getGameIndex") // 通过日期获得一天某场比赛
    public ArrayList<Map> getGameByDay(String date) throws ParseException {
        return teamScoreStats.getGameIndexByDay(date);
    }
}
