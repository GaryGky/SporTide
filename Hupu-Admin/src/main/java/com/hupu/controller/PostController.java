package com.hupu.controller;

import com.hupu.pojo.Post;
import com.hupu.service.Impl.CommentServiceImpl;
import com.hupu.service.Impl.PostServiceImpl;
import com.hupu.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    @Qualifier("postServiceImpl")
    private PostServiceImpl postService;
    
    @RequestMapping("/getLimitPost")
    public String getLimitPost(HttpServletRequest request) {
        System.out.println("获取帖子");
        request.getSession().setAttribute("postMap",
                postService.getPostList(100));
        return "Success";
    }
    
    @RequestMapping("/delPost")
    public String delPost(int id, HttpServletRequest request) {
        System.out.println("要删除的post id ===> " + id);
        String resMsg = "";
        int delRes = postService.deletePostById(id);
        resMsg = delRes > 0 ? "del-success" : "del-fail";
        request.getSession().setAttribute("postMap",
                postService.getPostList(100));
        return resMsg;
    }
    
    @RequestMapping("/createPost")
    public int createPost(Post post) {
        postService.createPost(post);
        return 0;
    }
}
