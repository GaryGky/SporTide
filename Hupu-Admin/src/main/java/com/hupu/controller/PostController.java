package com.hupu.controller;

import com.hupu.pojo.Comment;
import com.hupu.pojo.Post;
import com.hupu.service.Impl.CommentServiceImpl;
import com.hupu.service.Impl.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class PostController {
    @Autowired
    @Qualifier("postServiceImpl")
    private PostServiceImpl postService;
    
    @Autowired
    @Qualifier("commentServiceImpl")
    private CommentServiceImpl commentService;
    
    @RequestMapping("/allPost")
    public List<Post> getAllPost() {
        System.out.println("刷新帖子");
        return postService.queryAllPost();
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
    
    @RequestMapping("/getAllCom")
    public List<Comment> getAllComment() {
        System.out.println("产生评论");
        return commentService.queryAllCom();
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
