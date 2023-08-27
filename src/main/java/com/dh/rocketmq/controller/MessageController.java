package com.dh.rocketmq.controller;

import com.dh.rocketmq.producer.MessageProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("producer")
public class MessageController {

    @Resource
    MessageProducer messageProducer;

    /**
     * 同步
     */
    @PostMapping("syncSend")
    public void syncSend() {
        messageProducer.syncSend();
    }

    /**
     * 同步集群
     */
    @PostMapping("syncSendClustering")
    public void syncSendClustering() {
        messageProducer.syncSendClustering();
    }

    /**
     * 同步广播
     */
    @PostMapping("syncSendBroadcasting")
    public void syncSendBroadcasting(){
        messageProducer.syncSendBroadcasting();
    }

    /**
     * 同步顺序消息
     */
    @PostMapping("syncSendOrderly")
    public void syncSendOrderly(){
        messageProducer.syncSendOrderly();
    }

    /**
     * 同步过滤
     */
    @PostMapping("syncSendFilterBySql")
    public void syncSendFilterBySql(){
        messageProducer.syncSendFilterBySql();
    }

    /**
     * 同步批量
     */
    @PostMapping("syncSendBatch")
    public void syncSendBatch(){
        messageProducer.syncSendBatch();
    }

    /**
     * 同步延迟消息
     */
    @PostMapping("syncSendDelay")
    public void syncSendDelay(){
        messageProducer.syncSendDelay();
    }

    /**
     * 异步
     */
    @PostMapping("asyncSend")
    public void asyncSend() {
        messageProducer.asyncSend();
    }

    /**
     * 异步顺序消息
     */
    @PostMapping("asyncSendOrderly")
    public void asyncSendOrderly() {
        messageProducer.asyncSendOrderly();
    }

    /**
     * 单向
     */
    @PostMapping("sendOneWay")
    public void sendOneWay(){
        messageProducer.sendOneWay();
    }

    /**
     * 单向顺序消息
     */
    @PostMapping("sendOneWayOrderly")
    public void sendOneWayOrderly(){
        messageProducer.sendOneWayOrderly();
    }

    /**
     * 单向顺序消息
     */
    @PostMapping("sendTransaction")
    public void sendTransaction(){
        messageProducer.sendTransaction();
    }


}
