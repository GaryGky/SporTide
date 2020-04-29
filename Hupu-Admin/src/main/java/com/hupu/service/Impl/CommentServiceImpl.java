package com.hupu.service.Impl;

import com.hupu.dao.CommentMapper;
import com.hupu.dao.PostMapper;
import com.hupu.dao.UserDao;
import com.hupu.pojo.Comment;
import com.hupu.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    @Qualifier("commentMapper")
    private CommentMapper commentMapper;
    
    @Autowired
    @Qualifier("postMapper")
    private PostMapper postMapper;
    
    @Autowired
    @Qualifier("userDao")
    private UserDao userDao;
    
    
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
    
    @Override
    public List<Comment> queryAllCom() {
        return commentMapper.queryAllCom();
    }
    
    @Override
    public List<Comment> queryCommentByLimit(int offset, int limit) {
        return commentMapper.queryCommentByLimit(offset, limit);
    }
    
    @Override
    public List<HashMap<String, Object>> getComList(int entity) {
        ArrayList<HashMap<String, Object>> mapArrayList = new ArrayList<>();
        for (Comment comment : commentMapper.queryCommentByLimit(0,entity)) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("id", comment.getId());
            map.put("from_user_name",
                    userDao.queryById(comment.getFrom_uid()).getUserNikename());
            map.put("post_label",
                    postMapper.queryPostById(comment.getPost_id()).getPost_info());
            map.put("info", comment.getInfo());
            map.put("time", comment.getTime());
            mapArrayList.add(map);
        }
        return mapArrayList;
    }
}
