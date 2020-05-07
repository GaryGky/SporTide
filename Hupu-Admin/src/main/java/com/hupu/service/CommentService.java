package com.hupu.service;

import com.hupu.pojo.Comment;

import java.util.HashMap;
import java.util.List;

public interface CommentService {
    public int createCom(int id, String info, String status,
                         String time, int post_id,
                         int from_uid, int to_uid); // 创建一条评论
    
    public int createCom(Comment comment);
    
    public int deleteComById(int id); // 删除一条评论
    
    public Comment queryComById(int id); // 通过id查找评论
    
    // 查找某人发表的评论
    public List<Comment> queryComByFromUid(int from_uid);
    
    // 查找一个帖子下的评论
    public List<Comment> queryComByPostId(int post_id);
    
    public List<Comment> queryAllCom();
    
    public List<Comment> queryCommentByLimit(int offset,int limit);
    
    public List<HashMap<String,Object>> getComList(int entity);
}
