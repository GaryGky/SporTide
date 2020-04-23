package com.hupu.service.Impl;

import com.hupu.dao.PostMapper;
import com.hupu.pojo.Post;
import com.hupu.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    @Qualifier("postMapper")
    private PostMapper postMapper;
    
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
    
    public Post queryPostById(int id){
        return postMapper.queryPostById(id);
    }
}
