package com.hupu.jpush;

import com.hupu.service.Impl.UserServiceImpl;
import com.hupu.utils.Jpush;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class JPushTest {
    private Jpush jpush = new Jpush();
    
    @Autowired
    private UserServiceImpl userService;
    
    @Test
    public void test(){
        ArrayList<String> strings = (ArrayList<String>) userService.getAllUserName();
        strings.add("pxy");
        for(String str:strings){
            jpush.jiguangPush(str,"TEST");
        }
    }
}
