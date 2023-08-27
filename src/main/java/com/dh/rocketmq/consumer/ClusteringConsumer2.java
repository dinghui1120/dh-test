package com.dh.rocketmq.consumer;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(topic = "clustering-topic",
        consumerGroup = "clustering-group")
public class ClusteringConsumer2 implements RocketMQListener<String> {

    @Override
    public void onMessage(String message) {
        System.out.println("集群消费者2,接收到消息:" + message);
    }

}
