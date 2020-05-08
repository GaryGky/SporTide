package com.hupu.controller;

import com.hupu.pojo.Comment;
import com.hupu.service.Impl.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/comment")
public class ComController {
    
    @Autowired
    @Qualifier("commentServiceImpl")
    private CommentServiceImpl commentService;
    
    @RequestMapping("/getLimitCom")
    public String getLimitComment(HttpServletRequest request,
                                  HttpServletResponse response) throws ServletException, IOException {
        System.out.println("产生评论");
        request.getSession().setAttribute("comMap",
                commentService.getComList(100));
        return "Success";
    }
    
    @RequestMapping("/delComment")
    public String delComment(int id, HttpServletRequest request) {
        System.out.println("要删除的comment id ===> " + id);
        String resMsg = "";
        int delRes = commentService.deleteComById(id);
        resMsg = delRes > 0 ? "del-success" : "del-fail";
        request.getSession().setAttribute("comMap",
                commentService.getComList(100));
        return resMsg;
    }
    
    @RequestMapping("/createCom")
    public String createCom(@RequestBody Comment comment) {
        System.out.println(comment);
        return commentService.createCom(comment) == 1 ? "Success" : "Fail";
    }
}
