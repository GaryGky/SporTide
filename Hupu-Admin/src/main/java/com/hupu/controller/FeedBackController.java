package com.hupu.controller;

import com.hupu.pojo.FeedBack;
import com.hupu.service.Impl.FeedBackServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/feedback")
public class FeedBackController {
    @Autowired
    @Qualifier("feedbackService")
    private FeedBackServiceImpl feedBackService;

    @RequestMapping("/recvFeedBack")
    public String recvFeedBack(@RequestBody Map map){
        System.out.println(map.toString());
        int userId = (int)map.get("user_id");
        String feedBackContent = (String)map.get("content");
        String time = (String)map.get("time");
        FeedBack feedBack = new FeedBack();
        feedBack.setFeedback_content(feedBackContent);
        feedBack.setFeedback_time(time);
        feedBack.setUser_id(userId);
        int flag = feedBackService.insertFeedBack(feedBack);
        if (flag == 1) {
            return "feed back has been received";
        }
        else {
            return "there is something wrong with database operations";
        }
    }

    @RequestMapping("/repFeedBack")
    public String repFeedBack(int user_id, int feedbackId, String replyContent, String time){
        int flag = feedBackService.addReply(replyContent, time, feedbackId);
        if (flag == 1) {
            return "reply has been stored";
        }
        else {
            return "there is something wrong with database operations";
        }
        //给该用户发送通知

    }

    @RequestMapping("/getFeedBacks")
    public List<FeedBack> getFeedBacks(int entries){
        List<FeedBack> list = feedBackService.queryAllByLimit(0, entries);
        return list;
    }

    @RequestMapping("/getFeedBacksByUser")
    public List<FeedBack> getFeedBacksByUser(int user_id){
        List<FeedBack> list = feedBackService.queryFeedBackByUserId(user_id);
        return list;
    }

}
