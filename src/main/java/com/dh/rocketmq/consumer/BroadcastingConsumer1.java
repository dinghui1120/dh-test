package com.dh.rocketmq.consumer;

import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(topic = "broadcasting-topic",
        consumerGroup = "broadcasting-group",
        messageModel = MessageModel.BROADCASTING)
public class BroadcastingConsumer1 implements RocketMQListener<String> {

    @Override
    public void onMessage(String message) {
        System.out.println("广播消费者1,接收到消息:" + message);
    }

}
