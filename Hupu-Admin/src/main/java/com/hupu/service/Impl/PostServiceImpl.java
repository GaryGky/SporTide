package com.hupu.service.Impl;

import com.hupu.dao.PostMapper;
import com.hupu.dao.UserDao;
import com.hupu.pojo.Post;
import com.hupu.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    @Qualifier("postMapper")
    private PostMapper postMapper;
    
    @Autowired
    @Qualifier("userDao")
    private UserDao userDao;
    
    public int createPost(int id, String type, String info, String createTime, int user_id) {
        return postMapper.createPost(id, type, info, createTime, user_id);
    }
    
    public int updateAddCol(int id) {
        return postMapper.updateAddCol(id);
    }
    
    public int updateSubCol(int id) {
        return postMapper.updateSubCol(id);
    }
    
    public int updateAddCom(int id) {
        return postMapper.updateAddCom(id);
    }
    
    public int updateSubCom(int id) {
        return postMapper.updateSubCom(id);
    }
    
    public int updateAddTran(int id) {
        return postMapper.updateAddTran(id);
    }
    
    public int updateSubTran(int id) {
        return postMapper.updateSubTran(id);
    }
    
    public int deletePostById(int id) {
        return postMapper.deletePostById(id);
    }
    
    public List<Post> queryPostsByUser(String user_name) {
        return postMapper.queryPostsByUser(user_name);
    }
    
    public List<Post> queryPostsByType(String type) {
        return postMapper.queryPostsByType(type);
    }
    
    @Override
    public List<Post> queryAllPost() {
        return postMapper.queryAllPost();
    }
    
    @Override
    public List<Post> queryPostByLimit(int offset, int limit) {
        return postMapper.queryPostByLimit(offset, limit);
    }
    
    public Post queryPostById(int id) {
        return postMapper.queryPostById(id);
    }
    
    @Override
    public ArrayList<HashMap<String, Object>> getPostList(int entities) {
        ArrayList<HashMap<String, Object>> mapArrayList = new ArrayList<>();
        for (Post post : postMapper.queryPostByLimit(0, 100)) {
            HashMap<String, Object> map = new HashMap<>();
            String name = userDao.queryById(post.getUser_id()).getUserNikename();
            map.put("post_id", post.getPost_id());
            map.put("post_info", post.getPost_id());
            map.put("post_type", post.getPost_id());
            map.put("user_name", name);
            map.put("post_time", post.getPost_id());
            map.put("post_commentNum", post.getPost_id());
            map.put("post_collectNum", post.getPost_id());
            map.put("post_transpondNum", post.getPost_id());
            mapArrayList.add(map);
        }
        return mapArrayList;
    }
}
