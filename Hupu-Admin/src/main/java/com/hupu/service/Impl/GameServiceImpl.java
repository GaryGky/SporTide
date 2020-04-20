package com.hupu.service.Impl;


import com.hupu.dao.GameDao;
import com.hupu.pojo.Game;
import com.hupu.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * (Game)表服务实现类
 *
 * @author makejava
 * @since 2020-04-20 12:40:18
 */
@Service("gameService")
@Transactional
public class GameServiceImpl implements GameService {
    @Autowired
    @Qualifier("gameDao")
    private GameDao gameDao;
    
    @Override
    public Game queryById(Integer gameid) {
        return gameDao.queryById(gameid);
    }
    
    @Override
    public List<Game> queryAllByLimit(int offset, int limit) {
        return gameDao.queryAllByLimit(offset, limit);
    }
    
    @Override
    public List<Game> queryAll(Game game) {
        return gameDao.queryAll(game);
    }
    
    @Override
    public int insert(Game game) {
        return gameDao.insert(game);
    }
    
    @Override
    public int update(Game game) {
        return gameDao.update(game);
    }
    
    @Override
    public int deleteById(Integer gameid) {
        return gameDao.deleteById(gameid);
    }
}