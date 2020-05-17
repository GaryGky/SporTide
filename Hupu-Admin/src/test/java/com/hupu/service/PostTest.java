package com.hupu.service;

import com.alibaba.fastjson.JSON;
import com.hupu.pojo.Post;
import com.hupu.service.Impl.PostServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/application-context.xml"})

public class PostTest {
    @Autowired
    private PostServiceImpl postService;
    
    @Test
    public void testInsert() {
        postService.insert(new Post(1, "title", "content", "time", 1, 1, "url"));
    }
}
