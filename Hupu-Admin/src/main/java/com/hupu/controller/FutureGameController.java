package com.hupu.controller;

import com.hupu.config.HupuEnum;
import com.hupu.pojo.FutureGames;
import com.hupu.service.Impl.FutureGamesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/future")
public class FutureGameController {
    @Autowired
    @Qualifier("futureGamesService")
    private FutureGamesServiceImpl futureGamesService;
    
    @RequestMapping("/getGamePreView") // 获得比赛前瞻
    public Map getGamePreView(String teamId){
        return futureGamesService.getTeamPreview(teamId);
    }
}
