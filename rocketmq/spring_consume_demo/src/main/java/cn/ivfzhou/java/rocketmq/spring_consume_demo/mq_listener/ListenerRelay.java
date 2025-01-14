package cn.ivfzhou.java.rocketmq.spring_consume_demo.mq_listener;

import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQReplyListener;
import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(consumerGroup = "default", topic = "topic", selectorExpression = "relay")
public class ListenerRelay implements RocketMQReplyListener<MessageExt, byte[]> {

    @Override
    public byte[] onMessage(MessageExt messageExt) {
        System.out.println(new String(messageExt.getBody()));
        return "OK".getBytes();
    }

}
