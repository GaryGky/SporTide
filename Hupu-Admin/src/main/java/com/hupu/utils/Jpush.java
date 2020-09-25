package com.hupu.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Encoder;

/**
 * java后台极光推送方式一：使用Http API
 * 此种方式需要自定义http请求发送客户端:HttpClient
 */
@SuppressWarnings( {"deprecation", "restriction"})
public class Jpush {
    private static final Logger log = LoggerFactory.getLogger(Jpush.class);
    private static String masterSecret = "7381f6918d84441f62b3235d";
    private static String appKey = "185e3f53560539e37fe44c0c";
    private static String pushUrl = "https://api.jpush.cn/v3/push";
    private static boolean apns_production = true;
    private static int time_to_live = 86400;
    
    public Jpush() {
    
    }
    
    /**
     * 极光推送
     */
    public void jiguangPush(int postId, String message) {
        try {
            String result = push(pushUrl, postId, message, appKey, masterSecret,
                    apns_production, time_to_live);
            JSONObject resData = JSONObject.parseObject(result);
            if (resData.containsKey("error")) {
                log.info("针对POSTID为" + postId + "的信息推送失败！");
                JSONObject error = JSONObject.parseObject(String.valueOf(resData.get("error")));
                log.info("错误信息为：" + error.get("message").toString());
            } else {
                log.info("针对POSTID为" + postId + "的信息推送成功！");
            }
        } catch (Exception e) {
            log.error("针对POSTID为" + postId + "的信息推送失败！", e);
        }
    }
    
    /**
     * 组装极光推送专用json串
     *
     * @param postId
     * @param alert
     * @return json
     */
    public static JSONObject generateJson(int postId, String alert,
                                          boolean apns_production, int time_to_live) {
        JSONObject json = new JSONObject();
        JSONArray platform = new JSONArray();//平台
        platform.add("android");
        platform.add("ios");
        
        JSONObject notification = new JSONObject();//通知内容
        JSONObject android = new JSONObject();//android通知内容
        android.put("alert", alert);
        android.put("builder_id", 1);
        JSONObject android_extras = new JSONObject();//android额外参数
        android_extras.put("type", "infomation");
        android_extras.put("postId", postId);
        android.put("extras", android_extras);
        
        
        JSONObject ios = new JSONObject();//ios通知内容
        ios.put("alert", alert);
        ios.put("sound", "default");
        ios.put("badge", "+1");
        JSONObject ios_extras = new JSONObject();//ios额外参数
        ios_extras.put("type", "infomation");
        ios.put("extras", ios_extras);
        notification.put("android", android);
        notification.put("ios", ios);
        
        JSONObject options = new JSONObject();//设置参数
        options.put("time_to_live", time_to_live);
        options.put("apns_production", apns_production);
        
        json.put("platform", platform);
        json.put("audience", "all");
        json.put("notification", notification);
        json.put("options", options);
        return json;
        
    }
    
    /**
     * 推送方法-调用极光API
     *
     * @param reqUrl
     * @param postId
     * @param alert
     * @return result
     */
    public static String push(String reqUrl, int postId, String alert,
                              String appKey, String masterSecret, boolean apns_production, int time_to_live) {
        String base64_auth_string = encryptBASE64(appKey + ":" + masterSecret);
        String authorization = "Basic " + base64_auth_string;
        return sendPostRequest(reqUrl, generateJson(postId, alert,
                apns_production, time_to_live).toString(), "UTF-8", authorization);
    }
    
    /**
     * 发送Post请求（json格式）
     *
     * @param reqURL
     * @param data
     * @param encodeCharset
     * @param authorization
     * @return result
     */
    @SuppressWarnings( {"resource"})
    public static String sendPostRequest(String reqURL, String data, String encodeCharset, String authorization) {
        HttpPost httpPost = new HttpPost(reqURL);
        HttpClient client = HttpClientBuilder.create().build();
        HttpResponse response = null;
        String result = "";
        try {
            StringEntity entity = new StringEntity(data, encodeCharset);
            entity.setContentType("application/json");
            httpPost.setEntity(entity);
            httpPost.addHeader("Authorization", authorization.trim());
            httpPost.addHeader("audience", "all");
            response = client.execute(httpPost);
            result = EntityUtils.toString(response.getEntity(), encodeCharset);
        } catch (Exception e) {
            log.error("请求通信[" + reqURL + "]时偶遇异常,堆栈轨迹如下", e);
        } finally{
            client.getConnectionManager().shutdown();
        }
        return result;
    }
    
    /**
     * 　　　　* BASE64加密工具
     */
    public static String encryptBASE64(String str) {
        byte[] key = str.getBytes();
        BASE64Encoder base64Encoder = new BASE64Encoder();
        String strs = base64Encoder.encodeBuffer(key);
        return strs;
    }
}