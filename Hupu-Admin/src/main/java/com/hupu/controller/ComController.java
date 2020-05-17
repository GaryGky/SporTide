package com.hupu.controller;


import com.hupu.pojo.Comment;
import com.hupu.service.Impl.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class ComController {
    @Autowired
    private CommentServiceImpl commentService;
    
    @RequestMapping("/addComment")
    public int addComment(@RequestBody Comment comment) {
        return commentService.insert(comment);
    }
    
    @RequestMapping("/getCommentByTopic")
    public List<Comment> getCommentByTopic(int topicId, int topicType) {
        return commentService.getCommentByTopic(topicId, topicType);
    }
    
}
