package com.dh.rocketmq.consumer;

import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(topic = "orderly-topic",
        consumerGroup = "orderly-topic-group",
        consumeMode = ConsumeMode.ORDERLY)
public class MessageOrderlyConsumer implements RocketMQListener<String> {

    @Override
    public void onMessage(String message) {
        System.out.println("接收到消息:" + message);
    }

}
