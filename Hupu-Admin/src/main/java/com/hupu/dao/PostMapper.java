package com.hupu.dao;

import com.hupu.pojo.Post;

import java.util.List;

public interface PostMapper {
    // 创建一个帖子
    public int createPost(int id, String type, String info, String createTime);
    
    // 更新帖子信息
    public void updateAddCol(int id); // 增加帖子的收藏量
    
    public void updateSubCol(int id); // 减少帖子的收藏量
    
    public int updateAddCom(int id); // 增加帖子的评论数
    
    public int updateSubCom(int id); // 减少帖子的评论数
    
    public int updateAddTran(int id); // 增加帖子的转发
    
    public int updateSubTran(int id); // 减少帖子的转发
    
    public int deletePostById(int id); // 删除一个帖子
    
    public List<Post> queryPostsByUser(int user_id); // 按照用户查询帖子
    
    public List<Post> queryPostsByType(String type); // 按照类型查询帖子
    
}
