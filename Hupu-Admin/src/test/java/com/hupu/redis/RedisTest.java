package com.hupu.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.model.InitializationError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring-*.xml"})
public class RedisTest {
    @Autowired
    private RedisTemplate redisTemplate;
    
    @Test
    public void test1() {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set("first", "Hello World");
        System.out.println(valueOperations.get("first"));
    }
}
