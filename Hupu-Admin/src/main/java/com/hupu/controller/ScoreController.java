package com.hupu.controller;

import com.hupu.pojo.Score;
import com.hupu.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class ScoreController {
    @Autowired
    @Qualifier("ScoreServiceImpl")
    private ScoreService scoreService;
    
    @RequestMapping("/getScore")
    public List<Score> test1(String date) throws IOException {
        System.out.println(date);
        return scoreService.queryScoreByDate(date);
    }
    
}
