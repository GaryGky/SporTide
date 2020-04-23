package com.hupu.service.Impl;


import com.hupu.dao.UserDao;
import com.hupu.pojo.User;
import com.hupu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2020-04-23 18:56:43
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    
    @Autowired
    @Qualifier("userDao")
    private UserDao userDao;
    
    @Override
    public User queryById(Integer userId) {
        return userDao.queryById(userId);
    }
    
    @Override
    public List<User> queryAllByLimit(int offset, int limit) {
        return userDao.queryAllByLimit(offset, limit);
    }
    
    @Override
    public List<User> queryAll(User user) {
        return userDao.queryAll(user);
    }
    
    @Override
    public int insert(User user) {
        return userDao.insert(user);
    }
    
    @Override
    public int update(User user) {
        return userDao.update(user);
    }
    
    @Override
    public int deleteById(Integer userId) {
        return userDao.deleteById(userId);
    }
}