package com.hupu.service.Impl;

import com.hupu.utils.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

@Component
@ServerEndpoint("/webSocket")
public class WebSocketService {
    private Session session;
    private static CopyOnWriteArraySet<WebSocketService> webSocketServiceSet
            = new CopyOnWriteArraySet<>();
    // 日志跟踪对象
    private final Logger logger =
            LoggerFactory.getLogger(RedisUtil.class);
    
    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        webSocketServiceSet.add(this);
        logger.info("OPEN SESSION, TOTAL SIZE:{}", webSocketServiceSet.size());
    }
    
    @OnClose
    public void opClose(){
        webSocketServiceSet.remove(this);
        System.out.println("Session close");
    }
    
    @OnMessage
    public void onMessage(String message){ // 获取客户端消息
        System.out.println("get message from client : " + message);
    }
    
    public void sendMessage(String message){
        for (WebSocketService webSocket: webSocketServiceSet){
            try {
                webSocket.session.getBasicRemote().sendText(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
