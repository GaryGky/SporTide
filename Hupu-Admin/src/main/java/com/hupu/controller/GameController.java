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
//            request.getRequestDispatcher("/Home_GameTable.jsp").forward(request, response);
            return "exist";
        }
        int entity = 2000; // 一次性请求全部
        // 由比赛id索引比赛，每个比赛是一个hashmap，由string类型指向不同的信息
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
    
    @RequestMapping("/getScoreByGame")
    public HashMap<String, Object> getScoreByGame(int gameId) {
        HashMap<String, Object> map = new HashMap<>();
        for (TeamScoreStats teamScore :
                teamScoreStats.getTeamStatsByGameId(gameId)) {
            if (teamScore.getIshome() == 0) {
                map.put("away", teamScore);
            } else {
                map.put("home", teamScore);
            }
        }
        return map;
    }
    
    
    @RequestMapping("/getPlayerByGame") // 设置一个http请求
    public HashMap<String, Object> getPlayerStatsByGame(int gameId) {
        HashMap<String, Object> gameMap = new HashMap<>();
        // 查询一次数据库
        ArrayList<PlayerScoreStats> awayList = new ArrayList<>();
        ArrayList<PlayerScoreStats> homeList = new ArrayList<>();
        for (PlayerScoreStats playerStats : playerScoreStatsService.queryByGameId(gameId)) {
            if (playerStats.getTeamstatsid() % 10 == 0) {
                awayList.add(playerStats);
            } else {
                homeList.add(playerStats);
            }
        }
        gameMap.put("home", homeList);
        gameMap.put("away", awayList);
        return gameMap;
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
    
    @RequestMapping("/getTeamScoreByGame")
    public HashMap<String, Object> getTeamScoreByGame(int gameId) {
        System.out.println("TeamStats gameId ===> " + gameId);
        HashMap<String, Object> gameMap = new HashMap<>();
        List<PlayerScoreStats> listHome = new ArrayList<>();
        List<PlayerScoreStats> listAway = new ArrayList<>();
        for (PlayerScoreStats stats : playerScoreStatsService.queryByGameId(gameId)) {
            if (stats.getTeamstatsid() % 10 == 0) {
                listAway.add(stats);
            } else {
                listHome.add(stats);
            }
        }
        
        gameMap.put("home", getMap(listHome));
        gameMap.put("away", getMap(listAway));
        
        System.out.println(listHome);
        System.out.println(listAway);
        System.out.println(gameMap);
        
        return gameMap;
    }
    
    @RequestMapping("/getGameIndex")
    public ArrayList<Map> getGameByDay(String date) throws ParseException {
        SimpleDateFormat myFmt = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
        SimpleDateFormat format = new SimpleDateFormat("%yyyy%MM%dd%");
        Set<Integer> gameSet = new HashSet<>();
        List<TeamScoreStats> gameIndexByDay = teamScoreStats.getGameIndexByDay(format.format(myFmt.parse(date)));
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
}
