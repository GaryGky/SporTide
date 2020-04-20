package com.hupu.dao;

import com.hupu.pojo.Game;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Game)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-20 10:35:15
 */
public interface GameDao {

    /**
     * 通过ID查询单条数据
     *
     * @param gameid 主键
     * @return 实例对象
     */
    Game queryById(Integer gameid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Game> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param game 实例对象
     * @return 对象列表
     */
    List<Game> queryAll(Game game);

    /**
     * 新增数据
     *
     * @param game 实例对象
     * @return 影响行数
     */
    int insert(Game game);

    /**
     * 修改数据
     *
     * @param game 实例对象
     * @return 影响行数
     */
    int update(Game game);

    /**
     * 通过主键删除数据
     *
     * @param gameid 主键
     * @return 影响行数
     */
    int deleteById(Integer gameid);

}