package com.hupu.service;

import com.hupu.pojo.Post;
import com.hupu.service.Impl.PostServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class PostTest {
    private ApplicationContext context;
    private PostServiceImpl postService;
    
    @Before
    public void before() {
        context = new ClassPathXmlApplicationContext(
                "application-context.xml");
        postService = (PostServiceImpl) context.getBean("postServiceImpl");
    }
    
    @Test
    public void TestCreate() {
        System.out.println(postService.createPost(1, "type1", "info1", "time1", 1));
        System.out.println(postService.createPost(2, "type2", "info2", "time2", 2));
        System.out.println(postService.createPost(3, "type3", "info3", "time3", 3));
    }
    
    @Test
    public void TestQueryPost() {
        System.out.println("=====Query By Type=======");
        List<Post> queryPostsByType = postService.queryPostsByType("type");
        for (Post post : queryPostsByType) System.out.println(post);
        
        System.out.println("=====Query By Name=======");
        for (Post post :
                postService.queryPostsByUser("name"))
            System.out.println(post);
        
        System.out.println("===== update Add =====");
        System.out.println(postService.updateAddCom(1));
        System.out.println(postService.updateAddCom(1));
        System.out.println(postService.updateAddCom(1));
        System.out.println(postService.updateAddCom(1));
        System.out.println(postService.updateAddCom(1));
        System.out.println(postService.updateAddTran(2));
        System.out.println(postService.updateAddCol(3));
        
        System.out.println("===== update Sub =====");
        System.out.println(postService.updateSubCol(3));
        System.out.println(postService.updateSubCom(2));
        System.out.println(postService.updateSubTran(1));
    }
    
    @Test
    public void testDel() {
        System.out.println("====Test Delete======");
        System.out.println(postService.deletePostById(1));
        System.out.println(postService.deletePostById(2));
        System.out.println(postService.deletePostById(3));
    }
}
