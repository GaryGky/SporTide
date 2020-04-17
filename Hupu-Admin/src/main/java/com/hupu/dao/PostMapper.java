package com.hupu.dao;

import com.hupu.pojo.Post;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PostMapper {
    // 创建一个帖子
    public int createPost(
            @Param("id") int id,
            @Param("type") String type,
            @Param("info") String info,
            @Param("time") String createTime,
            @Param("user_id") int user_id);
    
    // 更新帖子信息
    public int updateAddCol(@Param("id") int id); // 增加帖子的收藏量
    
    public int updateSubCol(@Param("id") int id); // 减少帖子的收藏量
    
    public int updateAddCom(@Param("id") int id); // 增加帖子的评论数
    
    public int updateSubCom(@Param("id") int id); // 减少帖子的评论数
    
    public int updateAddTran(@Param("id") int id); // 增加帖子的转发
    
    public int updateSubTran(@Param("id") int id); // 减少帖子的转发
    
    public int deletePostById(@Param("id") int id); // 删除一个帖子
    
    public List<Post> queryPostsByUser(@Param("user_name") String user_name); //
    // 按照用户查询帖子
    
    public List<Post> queryPostsByType(@Param("type") String type); // 按照类型查询帖子
    
    public List<Post> queryAllPost(); // 查询所有帖子信息
    
}
