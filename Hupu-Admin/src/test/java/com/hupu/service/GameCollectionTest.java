package com.hupu.service;

import com.alibaba.fastjson.JSON;
import com.hupu.pojo.GameCollection;
import com.hupu.service.Impl.GameCollectionServiceImpl;
import com.hupu.utils.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/application-context.xml"})

public class GameCollectionTest {
    @Autowired
    private GameCollectionServiceImpl gameCollectionService;
    
    @Test
    public void testInsert() {
        gameCollectionService.insert(new GameCollection(1, 156542,
                DateUtils.getCurTime()));
    }
    
    @Test
    public void testGetUsrCollection(){
        System.out.println(gameCollectionService.getUserCollection(1));
    }
    
    @Test
    public void testBaseGet(){
        System.out.println(JSON.toJSON(gameCollectionService.queryAllByLimit(0,1)));
    }
}
