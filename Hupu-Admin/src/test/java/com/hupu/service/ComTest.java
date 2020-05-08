package com.hupu.service;

import com.alibaba.fastjson.JSON;
import com.hupu.pojo.Comment;
import com.hupu.service.Impl.CommentServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.stream.IntStream;

public class ComTest {
    private CommentServiceImpl commentService;
    
    @Before
    public void before() {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        commentService = (CommentServiceImpl) context.getBean("commentServiceImpl");
    }
    
    @Test
    public void testCreate() {
        System.out.println("=== Create ====");
        for (int i = 0; i < 10; i++) {
            int status = commentService.createCom(new Comment(i,
                    "info" + i, "status",
                    "time" + i, i, 3, (i * i) % 10));
            System.out.println(status);
        }
    }
    
    
    @Test
    public void testQuery() {
        System.out.println("===Query By ComId===");
        System.out.println(commentService.queryComById(1));
        System.out.println(commentService.queryComById(2));
        System.out.println(commentService.queryComById(3));
        System.out.println("===Query By From Uid===");
        commentService.queryComByFromUid(1).forEach(System.out::println);
        System.out.println("===Query By Post Id===");
        commentService.queryComByPostId(1).forEach(System.out::println);
        
    }
    
    @Test
    public void testLimit() {
        System.out.println("=== Limit ====");
        for (Comment comment : commentService.queryCommentByLimit(1, 2)) {
            System.out.println(JSON.toJSON(comment));
        }
    }
    
    @Test
    public void delete() {
        IntStream.range(0, 10).map(i -> commentService.deleteComById(i)).forEach(System.out::println);
    }
}
