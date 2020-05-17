package com.hupu.service.Impl;


import com.hupu.dao.GameCollectionDao;
import com.hupu.pojo.GameCollection;
import com.hupu.service.GameCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * (GameCollection)表服务实现类
 *
 * @author makejava
 * @since 2020-05-15 12:33:13
 */
@Service("gameCollectionService")
@Transactional
public class GameCollectionServiceImpl implements GameCollectionService {
    
    @Autowired
    @Qualifier("gameCollectionDao")
    private GameCollectionDao gameCollectionDao;
    
    @Override
    public GameCollection queryById(Integer id) {
        return null;
    }
    
    @Override
    public List<GameCollection> queryAllByLimit(int offset, int limit) {
        return null;
    }
    
    @Override
    public List<GameCollection> queryAll(GameCollection gameCollection) {
        return null;
    }
    
    @Override
    public GameCollection insert(GameCollection gameCollection) {
        return null;
    }
    
    @Override
    public GameCollection update(GameCollection gameCollection) {
        return null;
    }
    
    @Override
    public boolean deleteById(Integer id) {
        return false;
    }
}