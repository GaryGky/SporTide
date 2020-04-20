package com.hupu.controller;

import com.hupu.pojo.Game;
import com.hupu.pojo.TeamScoreStats;
import com.hupu.service.Impl.GameServiceImpl;
import com.hupu.service.Impl.TeamScoreStatsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class GameController {
    @Autowired
    @Qualifier("gameService")
    private GameServiceImpl gameService;
    
    @Autowired
    @Qualifier("teamScoreStatsService")
    private TeamScoreStatsServiceImpl teamScoreStats;
    
    @RequestMapping("/getGameByLimit")
    public ArrayList<HashMap<String, Object>> getGameByLimit(int pageNum,
                                                             int entries) {
//        System.out.println("接收更新比赛信息请求");
        // 由比赛id索引比赛，每个比赛是一个hashmap，由string类型指向不同的信息
        ArrayList<HashMap<String, Object>> gameInfo = new ArrayList<>();
        int offset = (pageNum - 1) * entries;
        List<Game> gameList = gameService.queryAllByLimit(offset, entries);
//        System.out.println("game num ===> " + gameList.size());
        for (Game game : gameList) {
//            System.out.println(game);
            int gameId = game.getGameid();
            // 只有两条信息，一条主队，一条客队
            List<TeamScoreStats> teamScoreStatsList =
                    teamScoreStats.getTeamStatsByGameId(gameId);
//            System.out.println("team num ===>" + teamScoreStatsList.size());
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
//        System.out.println("game info size: " + gameInfo.size());
        return gameInfo;
    }
}
