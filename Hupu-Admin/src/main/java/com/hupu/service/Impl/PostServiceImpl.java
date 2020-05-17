package com.hupu.service.Impl;


import com.hupu.dao.PostDao;
import com.hupu.pojo.Post;
import com.hupu.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * (Post)表服务实现类
 *
 * @author makejava
 * @since 2020-05-15 12:33:06
 */
@Service("postService")
@Transactional

public class PostServiceImpl implements PostService {
    
    @Autowired
    @Qualifier("postDao")
    private PostDao postDao;
    
    @Override
    public Post queryById(Integer postId) {
        return postDao.queryById(postId);
    }
    
    @Override
    public List<Post> queryAllByLimit(int offset, int limit) {
        return postDao.queryAllByLimit(offset, limit);
    }
    
    @Override
    public List<Post> queryAll(Post post) {
        return postDao.queryAll(post);
    }
    
    @Override
    public int insert(Post post) {
        return postDao.insert(post);
    }
    
    @Override
    public int update(Post post) {
        return postDao.update(post);
    }
    
    @Override
    public int deleteById(Integer postId) {
        return postDao.deleteById(postId);
    }
}