package cn.ivfzhou.java.rocketmq.demo;

import org.apache.rocketmq.client.exception.MQClientException;

import static cn.ivfzhou.java.rocketmq.demo.Consumer.consumeBroadcast;

public class ConsumerReplica {

    public static void main(String[] args) throws MQClientException {
        consumeBroadcast();
    }

}
