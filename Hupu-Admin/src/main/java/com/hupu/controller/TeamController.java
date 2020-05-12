package com.hupu.controller;

import com.alibaba.fastjson.JSON;
import com.hupu.pojo.Team;
import com.hupu.service.Impl.TeamServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@RestController
@RequestMapping("/team")
public class TeamController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    @Qualifier("teamService")
    private TeamServiceImpl teamService;
    
    @RequestMapping("/getTeamByLimit")
    public String getTeamByLimit(HttpServletRequest request) {
        System.out.println("获取球队信息");
        ArrayList<HashMap<String, Object>> teamInfo = new ArrayList<>();
        List<Team> teamList = teamService.queryAllByLimit(0, 50);
        for (Team team : teamList) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("id", team.getTeamid());
            map.put("name", team.getTeamname());
            map.put("buildtime", team.getBuildtime());
            map.put("area", team.getArea());
            map.put("homecourt", team.getHomecourt());
            map.put("chiefcoach", team.getChiefcoach());
            map.put("website",team.getWebsite());
            map.put("teamName",team.getTeamname());
            teamInfo.add(map);
        }
        request.getSession().setAttribute("teamInfo", teamInfo);
        System.out.println("获取球队信息成功");
        System.out.println(teamInfo.isEmpty());
        return "Success";
    }
    
    @RequestMapping(value = "/updateTeamInfo", method = RequestMethod.POST)
    public int updateTeamInfo(String teamId, String field, String new_value) {
        //根据字段进行修改
        Team team = teamService.queryById(teamId);
        switch (field) {
            case "teamId":
                team.setTeamid(new_value);
                break;
            case "teamName":
                team.setTeamname(new_value);
                break;
            case "buildTime":
                team.setBuildtime(new_value);
                break;
            case "teamArea":
                team.setArea(new_value);
                break;
            case "homeCourt":
                team.setHomecourt(new_value);
                break;
            case "chief":
                team.setChiefcoach(new_value);
                break;
        }
        logger.info(JSON.toJSONString(team));
        return teamService.update(team);
    }
}
