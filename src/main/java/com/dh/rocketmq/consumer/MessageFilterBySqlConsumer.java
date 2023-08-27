package com.dh.rocketmq.consumer;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.annotation.SelectorType;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(topic = "filter-topic",
        consumerGroup = "filter-topic-group",
        selectorType = SelectorType.SQL92,
        selectorExpression = "type = 'apple' and price > 2")
public class MessageFilterBySqlConsumer implements RocketMQListener<String> {

    @Override
    public void onMessage(String message) {
        System.out.println("接收到消息:" + message);
    }

}
