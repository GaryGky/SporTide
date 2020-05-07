package com.hupu.service;

import com.hupu.pojo.Post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface PostService {
    public int createPost(
            int id, String type, String info, String createTime, int user_id);
    public int createPost(Post post);
    // 更新帖子信息
    public int updateAddCol(int id); // 增加帖子的收藏量
    
    public int updateSubCol(int id); // 减少帖子的收藏量
    
    public int updateAddCom(int id); // 增加帖子的评论数
    
    public int updateSubCom(int id); // 减少帖子的评论数
    
    public int updateAddTran(int id); // 增加帖子的转发
    
    public int updateSubTran(int id); // 减少帖子的转发
    
    public int deletePostById(int id); // 删除一个帖子
    
    public List<Post> queryPostsByUser(String user_name); //
    // 按照用户查询帖子
    
    public List<Post> queryPostsByType(String type); // 按照类型查询帖子
    
    public List<Post> queryAllPost(); // 查询所有帖子信息
    
    public List<Post> queryPostByLimit(int offset, int limit);
    
    public Post queryPostById(int id);
    
    public ArrayList<HashMap<String,Object>> getPostList(int entities);
}
