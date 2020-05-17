package com.hupu.controller;

import com.hupu.pojo.Post;
import com.hupu.pojo.Recap;
import com.hupu.service.Impl.PostServiceImpl;
import com.hupu.service.Impl.RecapServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    @Qualifier("postService")
    private PostServiceImpl postService;
    
    @Autowired
    private RecapServiceImpl recapService;
    
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @RequestMapping("/upload")
    public String fileUpload(@RequestParam("file") CommonsMultipartFile file,
                             HttpServletRequest request) throws IOException {
        String path = "E:/root/upload";
        File realPath = new File(path);
        if (!realPath.exists()) {
            realPath.mkdir();
        }
        logger.info("文件上传路径" + realPath);
        logger.info("文件名" + file.getOriginalFilename());
        
        file.transferTo(new File(realPath + "/" + file.getOriginalFilename()));
        return "上传文件";
    }
    
    @RequestMapping("/getPostRecap")
    public Map<String, Object> getPostByDay(String foreDate, String backDate) {
        // 获取指定日期的战报
        List<Recap> recapList = recapService.getRecapByDay(foreDate, backDate);
        // 获取所有post
        List<Post> postList = postService.queryAllByLimit(0, 50);
        
        HashMap<String, Object> newsMap = new HashMap<>();
        newsMap.put("recapList", recapList);
        newsMap.put("postList", postList);
        return newsMap;
    }
}
