package cn.ivfzhou.java.redis.spring_redis;

import java.time.Duration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

public class SpringSample {

    public static void main(String[] args) {
        ApplicationContext ap = new ClassPathXmlApplicationContext("application.xml");
        RedisTemplate<String, Object> redisTemplate = ap.getBean(RedisTemplate.class);
        redisTemplate.opsForValue().set("hello", "world", Duration.ofSeconds(2));
        System.out.println(redisTemplate.opsForValue().get("hello"));
    }

}
