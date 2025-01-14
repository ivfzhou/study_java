package cn.ivfzhou.java.redis.springboot_redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RedisController {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @RequestMapping("/get/{key}")
    @ResponseBody
    public String get(@PathVariable String key) {
        return redisTemplate.opsForValue().get(key).toString();
    }

    @RequestMapping("/set/{key}/{value}")
    @ResponseBody
    public void set(@PathVariable String key, @PathVariable String value) {
        redisTemplate.opsForValue().set(key, value);
    }

}
