package cn.ivfzhou.java.rocketmq.spring_consume_demo;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class ConsumeApplicationTest {

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @Test
    void test() {
        System.out.println(rocketMQTemplate.receive(String.class));
    }

}