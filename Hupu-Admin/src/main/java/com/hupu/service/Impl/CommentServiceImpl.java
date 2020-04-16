package com.hupu.service.Impl;

import com.hupu.dao.CommentMapper;
import com.hupu.pojo.Comment;
import com.hupu.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    @Qualifier("commentMapper")
    private CommentMapper commentMapper;
    
    public int createCom(int id, String info, String status, String time,
                         int post_id, int from_uid, int to_uid) {
        return commentMapper.createCom(id, info, status, time, post_id, from_uid, to_uid);
    }
    
    public int deleteComById(int id) {
        return commentMapper.deleteComById(id);
    }
    
    public Comment queryComById(int id) {
        return commentMapper.queryComById(id);
    }
    
    public List<Comment> queryComByFromUid(int from_uid) {
        return commentMapper.queryComByFromUid(from_uid);
    }
    
    public List<Comment> queryComByPostId(int post_id) {
        return commentMapper.queryComByPostId(post_id);
    }
}
