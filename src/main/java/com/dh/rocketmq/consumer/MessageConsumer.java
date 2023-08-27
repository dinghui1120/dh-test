package com.dh.rocketmq.consumer;

import cn.hutool.core.date.DateUtil;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RocketMQMessageListener(topic = "normal-topic",
        consumerGroup = "normal-topic-group")
public class MessageConsumer implements RocketMQListener<String> {

    @Override
    public void onMessage(String message) {
        System.out.println("接收到消息:" + message + ",当前时间:" + DateUtil.formatDateTime(new Date()));
    }

}
