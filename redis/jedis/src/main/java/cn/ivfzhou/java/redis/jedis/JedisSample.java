package cn.ivfzhou.java.redis.jedis;

import java.time.Duration;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisSample {

    public static void main(String[] args) {
        // System.out.println(operateTimesPerSecond());

        JedisPool jedisPool = newPool();
        redis.clients.jedis.Jedis resource = jedisPool.getResource();
        resource.set("hello", "world");
        System.out.println(resource.get("hello"));
    }

    public static JedisPool newPool() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(1000);
        poolConfig.setMaxIdle(100);
        poolConfig.setMinIdle(10);
        poolConfig.setMaxWait(Duration.ofMillis(2000));
        JedisPool jedisPool = new JedisPool(poolConfig, "ivfzhou-ubuntu", 6379);
        return jedisPool;
    }

    public static int operateTimesPerSecond() {
        try (redis.clients.jedis.Jedis jedis = new redis.clients.jedis.Jedis("ivfzhou-ubuntu", 6379, 3000/*毫秒*/)) {
            int i = 0;
            long start = System.currentTimeMillis();
            while (true) {
                if (System.currentTimeMillis() - start >= 1000) {
                    break;
                }
                jedis.set("test" + i, i + "");
                i++;
            }
            return i;
        }
    }

}
