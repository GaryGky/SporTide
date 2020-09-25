package com.hupu.jpush;

import com.hupu.pojo.Post;
import com.hupu.service.Impl.PostServiceImpl;
import com.hupu.service.Impl.UserServiceImpl;
import com.hupu.utils.Jpush;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/application-context.xml"})

public class JPushTest {
    private Jpush jpush = new Jpush();
    
    @Autowired
    private UserServiceImpl userService;
    
    @Autowired
    private PostServiceImpl postService;
    
    @Test
    public void test(){
        System.out.println(userService.getAllUserName());
        ArrayList<String> strings = (ArrayList<String>) userService.getAllUserName();
        Post post = postService.queryById(2);
        System.out.println(post);
        jpush.jiguangPush(post.getPostId(),post.getPostTitle());
    }
}
