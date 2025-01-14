package cn.ivfzhou.java.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "sample_queue")
public class SampleListener {

    @RabbitHandler
    public void handle(String str) {
        System.out.println("sample_queue监听到：" + str);
    }

}
