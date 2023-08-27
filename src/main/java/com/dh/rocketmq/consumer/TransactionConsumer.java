package com.dh.rocketmq.consumer;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(topic = "transaction-topic",
        consumerGroup = "transaction-topic-group")
public class TransactionConsumer implements RocketMQListener<String> {

    @Override
    public void onMessage(String message) {
        System.out.println("接收到消息:" + message);
    }

}
