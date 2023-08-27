package com.dh.rocketmq.producer;

import cn.hutool.core.date.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.TransactionSendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Component
public class MessageProducer {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    /**
     * 同步
     */
    public void syncSend() {
        String destination = "normal-topic:sync";
        String message = "这是一条同步消息";
        SendResult result = rocketMQTemplate.syncSend(destination, message);
        System.out.println(result);
    }

    /**
     * 同步集群
     */
    public void syncSendClustering() {
        for (int i = 0; i < 5; i++) {
            String destination = "clustering-topic";
            String message = "这是一条同步消息" + i;
            SendResult sendResult = rocketMQTemplate.syncSend(destination, message);
            System.out.println(sendResult);
        }
    }

    /**
     * 同步广播
     */
    public void syncSendBroadcasting() {
        for (int i = 0; i < 5; i++) {
            String destination = "broadcasting-topic";
            String message = "这是一条同步消息" + i;
            rocketMQTemplate.syncSend(destination, message);
        }
    }

    /**
     * 同步顺序消息
     */
    public void syncSendOrderly() {
        String[] flows = {"订单支付", "订单发货", "订单物流", "订单完成"};
        for (int i = 0; i < flows.length; i++) {
            rocketMQTemplate.syncSendOrderly("orderly-topic", flows[i % flows.length], "9527");
        }
    }

    /**
     * 同步过滤
     */
    public void syncSendFilterBySql() {
        String destination = "filter-topic";
        List<Message> appleMessageList = new ArrayList<>();
        List<Message> bananaMessageList = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            MessageBuilder<String> message = MessageBuilder.withPayload("这是一条同步批量消息" + i);
            message.setHeader("price", i);
            if (i % 2 == 0) {
                message.setHeader("type", "apple");
                appleMessageList.add(message.build());
            } else {
                message.setHeader("type", "banana");
                bananaMessageList.add(message.build());
            }
        }
        rocketMQTemplate.syncSend(destination, appleMessageList);
        rocketMQTemplate.syncSend(destination, bananaMessageList);
    }

    /**
     * 同步批量
     */
    public void syncSendBatch() {
        String destination = "batch-topic";
        List<Message> messageList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            messageList.add(MessageBuilder.withPayload("这是一条同步批量消息" + i).build());
        }
        SendResult result = rocketMQTemplate.syncSend(destination, messageList);
        System.out.println(result);
    }

    /**
     * 同步延迟消息
     */
    public void syncSendDelay() {
        String destination = "normal-topic:sync";
        Message<String> message = MessageBuilder.withPayload("这是一条同步延迟消息").build();
        //private String messageDelayLevel = "1s 5s 10s 30s 1m 2m 3m 4m 5m 6m 7m 8m 9m 10m 20m 30m 1h 2h";
        SendResult result = rocketMQTemplate.syncSend(destination, message, 3000, 2);
        System.out.println(result);
        System.out.println(DateUtil.formatDateTime(new Date()));
    }

    /**
     * 异步
     */
    public void asyncSend() {
        String destination = "normal-topic:async";
        String message = "这是一条异步消息";
        rocketMQTemplate.asyncSend(destination, message, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                System.out.println("回调sendResult:" + sendResult);
            }

            @Override
            public void onException(Throwable e) {
                System.out.println(e.getMessage());
            }
        });
    }

    /**
     * 异步顺序消息
     */
    public void asyncSendOrderly() {
        String[] flows = {"订单支付", "订单发货", "订单物流", "订单完成"};
        for (int i = 0; i < flows.length; i++) {
            String destination = "orderly-topic:async";
            rocketMQTemplate.asyncSendOrderly(destination, flows[i % flows.length], "9527", new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    System.out.println("回调sendResult:" + sendResult);
                }

                @Override
                public void onException(Throwable e) {
                    System.out.println(e.getMessage());
                }
            });
        }
    }

    /**
     * 单向
     */
    public void sendOneWay() {
        String destination = "normal-topic:oneWay";
        String message = "这是一条单向消息";
        rocketMQTemplate.sendOneWay(destination, message);
    }


    /**
     * 单向顺序消息
     */
    public void sendOneWayOrderly() {
        String[] flows = {"订单支付", "订单发货", "订单物流", "订单完成"};
        for (int i = 0; i < flows.length; i++) {
            rocketMQTemplate.sendOneWayOrderly("orderly-topic", flows[i % flows.length], "9527");
        }
    }

    /**
     * 事务消息
     */
    public void sendTransaction() {
        String destination = "transaction-topic";
        Message<String> message = MessageBuilder.withPayload("这是一条事务消息").build();
        TransactionSendResult sendResult = rocketMQTemplate.sendMessageInTransaction(destination, message, "A");
        System.out.println(sendResult);
        System.out.println(sendResult.getLocalTransactionState() + ",当前时间:" + DateUtil.formatDateTime(new Date()));
    }

}
