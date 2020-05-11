package com.hupu.service;

import com.alibaba.fastjson.JSON;
import com.hupu.pojo.FutureGames;
import com.hupu.service.Impl.FutureGamesServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/application-context.xml"})
public class FutureGamesTest {
    @Autowired
    @Qualifier("futureGamesService")
    private FutureGamesServiceImpl futureGamesService;
    
    @Test
    public void futGameTest() {
        for (FutureGames games : futureGamesService.queryAllByLimit(0, 10)) {
            System.out.println(games);
        }
    }
    
    @Test
    public void testDate() throws ParseException {
        for (FutureGames games : futureGamesService.getFutureGameByDate("2020" +
                "-4-14")) {
            System.out.println(JSON.toJSON(games));
        }
    }
    
    @Test
    public void testPre() {
        System.out.println(futureGamesService.getTeamPreview("LAL"));
    }
}
