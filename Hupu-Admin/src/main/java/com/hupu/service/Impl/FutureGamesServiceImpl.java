package com.hupu.service.Impl;


import com.hupu.config.HupuEnum;
import com.hupu.dao.FutureGamesDao;
import com.hupu.dao.PlayerScoreStatsDao;
import com.hupu.dao.TeamDao;
import com.hupu.dao.TeamScoreStatsDao;
import com.hupu.pojo.FutureGames;
import com.hupu.service.FutureGamesService;
import com.hupu.utils.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

/**
 * (FutureGames)表服务实现类
 *
 * @author makejava
 * @since 2020-05-11 11:19:08
 */
@Service("futureGamesService")
@Transactional
public class FutureGamesServiceImpl extends Play2TeamStats implements FutureGamesService {
    
    @Autowired
    @Qualifier("futureGamesDao")
    private FutureGamesDao futureGamesDao;
    
    @Autowired
    @Qualifier("teamScoreStatsDao")
    private TeamScoreStatsDao statsDao;
    
    @Autowired
    @Qualifier("playerScoreStatsDao")
    private PlayerScoreStatsDao playerDao;
    
    @Autowired
    @Qualifier("redisUtil")
    private RedisUtil redisUtil;
    
    
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    
    @Override
    public FutureGames queryById(String gameid) {
        return futureGamesDao.queryById(gameid);
    }
    
    @Override
    public List<FutureGames> queryAllByLimit(int offset, int limit) {
        return futureGamesDao.queryAllByLimit(offset, limit);
    }
    
    @Override
    public List<FutureGames> queryAll(FutureGames futureGames) {
        return futureGamesDao.queryAll(futureGames);
    }
    
    @Override
    public int insert(FutureGames futureGames) {
        return futureGamesDao.insert(futureGames);
    }
    
    @Override
    public int update(FutureGames futureGames) {
        logger.info("更新未来赛事信息");
        return futureGamesDao.update(futureGames);
    }
    
    @Override
    public int deleteById(String gameid) {
        return futureGamesDao.deleteById(gameid);
    }
    
    @Override
    public List<FutureGames> getFutureGameByDate(String date) throws ParseException {
        SimpleDateFormat myFmt = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat format = new SimpleDateFormat("yyyy_M_d %");
        String queryDay = format.format(myFmt.parse(date));
        logger.info("AI预测查询日期 ====> " + queryDay);
        String key = queryDay + "future";
        if (redisUtil.hasKey(key)) {
            return (List) redisUtil.get(key);
        }
        List<FutureGames> list = futureGamesDao.getFutureGameByDate(queryDay);
        if (list.size() > 0) {
            redisUtil.set(key, list, HupuEnum.RedisExpTime.SHORT_TIME.getTime());
        }
        return list;
    }
    
    
    /*
    获得一支球队的赛季表现数据
    @param: 球队名称
     */
    @Override
    public HashMap<String, Object> getTeamPreview(String teamId) {
        logger.info("获取球队历史数据  => " + teamId);
        String key = teamId + "preview";
        if (redisUtil.hasKey(key)) {
            return (HashMap<String, Object>) redisUtil.get(key);
        }
        List<Integer> teamStatsIdList =
                futureGamesDao.getStatsByTeam(teamId); // 得到球队本赛季所有的比赛
        HashMap<String, Object> previewMap = new HashMap<>();
        double score = 0; // 得分
        double court = 0; // 篮板可以由前场后场篮板相加得到
        double assist = 0; // 助攻
        double steal = 0; // 抢断
        double block = 0; // 盖帽
        double shot = 0; // 出手
        double goal = 0; // 命中
        double shot3 = 0;
        double goal3 = 0;
        //TODO:优化这个循环
        for (Integer teamStatsId : teamStatsIdList) {
            // 得到一场比赛球队的球员数据的累加和
            // TODO:嵌套循环访问数据库，时间爆炸
            previewMap = getMap(playerDao.queryByTeamStatsId(teamStatsId));
            score += (double) previewMap.get("score");
            court += (double) previewMap.get("court");
            assist += (double) previewMap.get("assist");
            steal += (double) previewMap.get("steal");
            block += (double) previewMap.get("block");
            shot += (double) previewMap.get("shot");
            goal += (double) previewMap.get("goal");
            goal3 += (double) previewMap.get("goal3");
            shot3 += (double) previewMap.get("shot3");
        }
        previewMap.clear();
        previewMap.put("score", score / teamStatsIdList.size());
        previewMap.put("court", court / teamStatsIdList.size());
        previewMap.put("assist", assist / teamStatsIdList.size());
        previewMap.put("steal", steal / teamStatsIdList.size());
        previewMap.put("block", block / teamStatsIdList.size());
        previewMap.put("shot", shot / teamStatsIdList.size());
        previewMap.put("goal", goal / teamStatsIdList.size());
        previewMap.put("goal3", goal3 / teamStatsIdList.size());
        previewMap.put("shot3", shot3 / teamStatsIdList.size());
        previewMap.put("allGames", getAllGames(teamId));
        previewMap.put("winGames", getWinGames(teamId));
        previewMap.put("teamId", teamId);
        redisUtil.set(key, previewMap, HupuEnum.RedisExpTime.SS_LONG.getTime());
        return previewMap;
    }
    
    @Override
    public int getAllGames(String teamId) {
        String key = teamId + "AllGames";
        if (redisUtil.hasKey(key)) {
            return (int) redisUtil.get(key);
        }
        int allGames = futureGamesDao.getAllGames(teamId);
        redisUtil.set(key, allGames, HupuEnum.RedisExpTime.S_LONG.getTime());
        return allGames;
    }
    
    @Override
    public int getWinGames(String teamId) {
        String key = teamId + "WinGames";
        if (redisUtil.hasKey(key)) {
            return (int) redisUtil.get(key);
        }
        int winGames = futureGamesDao.getWinGames(teamId);
        redisUtil.set(key, winGames, HupuEnum.RedisExpTime.S_LONG.getTime());
        return winGames;
    }
    
    @Override
    public HashMap<String, Object> getGamePreview(int gameId) {
        FutureGames futureGames = futureGamesDao.queryById(String.valueOf(gameId));
        HashMap<String, Object> map = new HashMap<>();
        map.put("awayTeam", getTeamPreview(futureGames.getAway()));
        map.put("homeTeam", getTeamPreview(futureGames.getHome()));
        return map;
    }
}