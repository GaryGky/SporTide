package com.hupu.controller;

import com.hupu.pojo.Comment;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
    public String getLimitPost(HttpServletRequest request,
                               HttpServletResponse response) throws ServletException, IOException {
        System.out.println("获取帖子");
        ArrayList<HashMap<String, Object>> mapArrayList = new ArrayList<>();
        int entries = 100;
        for (Post post : postService.queryPostByLimit(0,
                entries)) {
            HashMap<String, Object> map = new HashMap<>();
            String name =
                    userService.queryById(post.getUser_id()).getUserNikename();
            map.put("post_id", post.getPost_id());
            map.put("post_info", post.getPost_id());
            map.put("post_type", post.getPost_id());
            map.put("user_name", name);
            map.put("post_time", post.getPost_id());
            map.put("post_commentNum", post.getPost_id());
            map.put("post_collectNum", post.getPost_id());
            map.put("post_transpondNum", post.getPost_id());
            mapArrayList.add(map);
        }
        request.getSession().setAttribute("postMap", mapArrayList);
        request.getRequestDispatcher("Home_PostingTable.jsp").forward(request
                , response);
        return "Success";
    }
    
    @RequestMapping("/delPost")
    public HashMap<String, Object> delPost(int id) {
        System.out.println("要删除的post id ===> " + id);
        String resMsg = "";
        HashMap<String, Object> map = new HashMap<>();
        int delRes = postService.deletePostById(id);
        if (delRes > 0) {
            resMsg = "del-success";
        } else {
            resMsg = "del-fail";
        }
        map.put("data", postService.queryAllPost());
        map.put("msg", resMsg);
        return map;
    }
    
    
    @RequestMapping("/getLimitCom")
    public String getLimitComment(HttpServletRequest request,
                                  HttpServletResponse response) throws ServletException, IOException {
        System.out.println("产生评论");
        int entries = 100;
        ArrayList<HashMap<String, Object>> mapArrayList = new ArrayList<>();
        for (Comment comment : commentService.queryCommentByLimit(0, entries)) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("id", comment.getId());
            map.put("from_user_name",
                    userService.queryById(comment.getFrom_uid()).getUserNikename());
            map.put("post_label",
                    postService.queryPostById(comment.getPost_id()).getPost_info());
            map.put("info", comment.getInfo());
            map.put("time", comment.getTime());
            mapArrayList.add(map);
        }
        request.getSession().setAttribute("comMap", mapArrayList);
        request.getRequestDispatcher("Home_CommentTable.jsp").forward(request
                , response);
        return "Success";
    }
    
    @RequestMapping("/delComment")
    public HashMap<String, Object> delComment(int id) {
        System.out.println("要删除的comment id ===> " + id);
        String resMsg = "";
        HashMap<String, Object> map = new HashMap<>();
        int delRes = commentService.deleteComById(id);
        if (delRes > 0) {
            resMsg = "del-success";
        } else {
            resMsg = "del-fail";
        }
        map.put("data", commentService.queryAllCom());
        map.put("msg", resMsg);
        return map;
    }
}
