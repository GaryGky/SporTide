package com.hupu.service;

import com.hupu.pojo.FutureGames;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;

/**
 * (FutureGames)表服务接口
 *
 * @author makejava
 * @since 2020-05-11 11:19:08
 */
public interface FutureGamesService {
    
    /**
     * 通过ID查询单条数据
     *
     * @param gameid 主键
     * @return 实例对象
     */
    FutureGames queryById(String gameid);
    
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<FutureGames> queryAllByLimit(int offset, int limit);
    
    List<FutureGames> queryAll(FutureGames futureGames);
    
    /**
     * 新增数据
     *
     * @param futureGames 实例对象
     * @return 实例对象
     */
    int insert(FutureGames futureGames);
    
    /**
     * 修改数据
     *
     * @param futureGames 实例对象
     * @return 实例对象
     */
    int update(FutureGames futureGames);
    
    /**
     * 通过主键删除数据
     *
     * @param gameid 主键
     * @return 是否成功
     */
    int deleteById(String gameid);
    
    List<FutureGames> getFutureGameByDate(String date) throws ParseException;
    
    HashMap<String, Object> getTeamPreview(String teamId);
}