package com.hupu.controller;

import com.hupu.pojo.Post;
import com.hupu.service.Impl.CommentServiceImpl;
import com.hupu.service.Impl.PostServiceImpl;
import com.hupu.service.Impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    @Qualifier("postServiceImpl")
    private PostServiceImpl postService;
    
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
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
    public int createPost(@RequestBody Post post) {
        System.out.println(post);
        return postService.createPost(post);
    }
    
    
    @RequestMapping("/upload")
    public String fileUpload(@RequestParam("file")CommonsMultipartFile file,
                             HttpServletRequest request) throws IOException {
        String path = "E:/root/upload";
        File realPath = new File(path);
        if(!realPath.exists()){
            realPath.mkdir();
        }
        logger.info("文件上传路径" + realPath);
        logger.info("文件名" + file.getOriginalFilename());
        
        file.transferTo(new File(realPath + "/" + file.getOriginalFilename()));
        return "上传文件";
    }
}
