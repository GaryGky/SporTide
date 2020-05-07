package com.hupu.controller;

import com.hupu.pojo.Team;
import com.hupu.service.Impl.TeamServiceImpl;
import javafx.beans.binding.ObjectExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/team")
public class TeamController {
    @Autowired
    @Qualifier("teamService")
    private TeamServiceImpl teamService;

    @RequestMapping("/getTeamByLimit")
    public String getTeamByLimit(HttpServletRequest request) {
        System.out.println("获取球队信息");
        ArrayList<HashMap<String, Object>> teamInfo = new ArrayList<>();
        List<Team> teamList = teamService.queryAllByLimit(0, 2000);
        for (Team team : teamList) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("id", team.getTeamid());
            map.put("name", team.getTeamname());
            map.put("buildtime", team.getBuildtime());
            map.put("area", team.getArea());
            map.put("homecourt", team.getHomecourt());
            map.put("chiefcoach", team.getChiefcoach());

            teamInfo.add(map);
        }
        request.getSession().setAttribute("teamInfo", teamInfo);
        System.out.println("获取球队信息成功");
        System.out.println(teamInfo.isEmpty());
        return "Success";
    }

    @RequestMapping("/updateTeamInfo")
    public String updateTeamInfo(String teamId, String field, String new_value){
        //根据字段进行修改
        Team team = teamService.queryById(teamId);
        switch (field) {
            case "id":
                team.setTeamid(new_value);
                break;
            case "name":
                team.setTeamname(new_value);
                break;
            case "buildtime":
                team.setBuildtime(new_value);
                break;
            case "area":
                team.setArea(new_value);
                break;
            case "homecourt":
                team.setHomecourt(new_value);
                break;
            case "chiefcoach":
                team.setChiefcoach(new_value);
                break;
        }
        teamService.update(team);
        return "Success";
    }
}
