package com.hupu.dao;

import com.hupu.pojo.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface CommentMapper {
    public int createCom(@Param("id") int id, @Param("info") String info,
                         @Param("status") String status,
                         @Param("time") String time,
                         @Param("post_id") int post_id,
                         @Param("from_uid") int from_uid,
                         @Param("to_uid") int to_uid); // 创建一条评论
    
    public int deleteComById(@Param("id") int id); // 删除一条评论
    
    public Comment queryComById(@Param("id") int id); // 通过id查找评论
    
    // 查找某人发表的评论
    public List<Comment> queryComByFromUid(@Param("from_uid") int from_uid);
    
    // 查找一个帖子下的评论
    public List<Comment> queryComByPostId(@Param("post_id") int post_id);
}
