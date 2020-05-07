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
        for (int i = 0; i < 10; i++) {
            System.out.println(postService.createPost(i, "type" + i, "info" + i,
                    "time" + i, i));
            System.out.println(postService.createPost(new Post(i+10, "type" + i
                    , "info" + i,
                    "time" + i, i, 0, 0, 0)));
        }
        
    }
    
    @Test
    public void testDel() {
        for (int i = 0; i < 20; i++) {
            System.out.println(postService.deletePostById(i));
        }
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
    public void testLimit() {
        System.out.println("=== Limit ====");
        postService.queryPostByLimit(1, 2).forEach(System.out::println);
    }
}
