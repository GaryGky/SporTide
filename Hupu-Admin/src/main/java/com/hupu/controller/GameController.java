package com.hupu.controller;

import com.hupu.pojo.Game;
import com.hupu.pojo.TeamScoreStats;
import com.hupu.service.Impl.GameServiceImpl;
import com.hupu.service.Impl.TeamScoreStatsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/game")
public class GameController {
    @Autowired
    @Qualifier("gameService")
    private GameServiceImpl gameService;
    
    @Autowired
    @Qualifier("teamScoreStatsService")
    private TeamScoreStatsServiceImpl teamScoreStats;
    
    private int pageNum = 1;
    
    @RequestMapping("/addPageNum")
    public void addPageNum() {
        pageNum++;
        System.out.println("pageNum===>" + pageNum);
    }
    
    @RequestMapping("/subPageNum")
    public void subPageNum() {
        pageNum--;
        if (pageNum <= 0) {
            pageNum = 1;
        }
        System.out.println("=pageNum===>" + pageNum);
    }
    
    @RequestMapping("/getGameByLimit")
    public String getGameByLimit(HttpServletRequest request,
                                 HttpServletResponse response,
                                 String entries) throws ServletException, IOException {
        if (request.getAttribute("gameInfo") != null) {
            request.getRequestDispatcher("/Home_GameTable.jsp").forward(request, response);
            return null;
        }
        int entity = 1000; // 一次性请求全部
//        System.out.println("接收更新比赛信息请求");
        // 由比赛id索引比赛，每个比赛是一个hashmap，由string类型指向不同的信息
        ArrayList<HashMap<String, Object>> gameInfo = new ArrayList<>();
        int offset = (pageNum - 1) * entity;
        List<Game> gameList = gameService.queryAllByLimit(offset, entity);
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
        request.getSession().setAttribute("gameInfo", gameInfo);
        request.getRequestDispatcher("/Home_GameTable.jsp").forward(request, response);
        return "Success";
    }
}
