package com.hupu.service;

import com.hupu.service.Impl.CommentServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
        System.out.println(commentService.createCom(1, "info2", "status",
                "time1", 1, 3, 1));
        System.out.println(commentService.createCom(2, "info3", "status",
                "time1", 1, 1, 2));
        System.out.println(commentService.createCom(3, "info1", "status",
                "time1", 2, 2, 3));
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
    
    public void testDel() {
        System.out.println("=== Del ====");
        
    }
}
