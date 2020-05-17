package com.hupu.controller;

import com.alibaba.fastjson.JSONObject;
import com.hupu.pojo.Post;
import com.hupu.pojo.Recap;
import com.hupu.service.Impl.AdminServiceImpl;
import com.hupu.service.Impl.PostServiceImpl;
import com.hupu.service.Impl.RecapServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.hupu.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
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

    @Autowired
    private AdminServiceImpl adminService;
    
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/createPost")
    public int createPost(String title, String content, String img_path, HttpSession session) {
        System.out.println("---------------------create post---------------------------");
        String time = DateUtils.getCurTime();
        System.out.println(time);
        int admin_id = adminService.queryIdByName(session.getAttribute("admin").toString());
        return postService.createPost(title, content, time, admin_id, img_path);
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public JSONObject fileUpload(@RequestParam("file") MultipartFile file) throws IOException {
        String path = "E:/photo";
        System.out.println("------------------------get in upload------------------------");
        File realPath = new File(path);
        if(!realPath.exists()){
            realPath.mkdirs();
        }
        JSONObject jsonObject = new JSONObject();
        try  {
            file.transferTo(new File(realPath + "/" + file.getOriginalFilename()));
            logger.info("文件上传路径" + realPath);
            logger.info("文件名" + file.getOriginalFilename());
            jsonObject.put("result", 1);
            jsonObject.put("path", realPath + "/" + file.getOriginalFilename());
            System.out.println("------------------------write success------------------------");
            return jsonObject;
        } catch (Exception e) {
            jsonObject.put("result", 0);
            e.printStackTrace();
            logger.error("文件上传失败!");
            return jsonObject;
        }
        //
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
