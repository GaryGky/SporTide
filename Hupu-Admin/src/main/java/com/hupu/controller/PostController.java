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
    
    @Autowired
    @Qualifier("commentServiceImpl")
    private CommentServiceImpl commentService;
    
    @Autowired
    @Qualifier("userService")
    private UserServiceImpl userService;
    
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
        request.setAttribute("postMap", postService.getPostList(100));
        return resMsg;
    }
    
    
    @RequestMapping("/getLimitCom")
    public String getLimitComment(HttpServletRequest request,
                                  HttpServletResponse response) throws ServletException, IOException {
        System.out.println("产生评论");
        request.getSession().setAttribute("comMap",
                commentService.getComList(100));
        return "Success";
    }
    
    @RequestMapping("/delComment")
    public String delComment(int id, HttpServletRequest request) {
        System.out.println("要删除的comment id ===> " + id);
        String resMsg = "";
        int delRes = commentService.deleteComById(id);
        resMsg = delRes > 0 ? "del-success" : "del-fail";
        request.setAttribute("comMap", commentService.getComList(100));
        return resMsg;
    }
    
    @RequestMapping("/createPost")
    public int createPost(Post post){
        //TODO:创建一个新帖
        return 0;
    }
    /*
    @RequestMapping("/delPost")
    public int delPost(Post post){
        // TODO: delete a post from database
        return 0;
    }
    */
}
