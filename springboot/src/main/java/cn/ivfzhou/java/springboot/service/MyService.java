package cn.ivfzhou.java.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionCommands;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MyService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Transactional
    public String doSomething() {
        Object execute = redisTemplate.execute((RedisCallback<String>) RedisConnectionCommands::ping);
        return execute.toString();
    }

}
