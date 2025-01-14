package cn.ivfzhou.java.rocketmq.spring_producer_demo;

import org.apache.rocketmq.spring.annotation.ExtRocketMQTemplateConfiguration;
import org.apache.rocketmq.spring.core.RocketMQTemplate;

@ExtRocketMQTemplateConfiguration(namespace = "${rocketmq.name-server}")
public class ExtRocketMQTemplate extends RocketMQTemplate {
}
