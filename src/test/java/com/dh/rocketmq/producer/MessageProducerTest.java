package com.dh.rocketmq.producer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * rocketmq
 * @author: dh
 * @date: 2023年08月14日
 **/
@SpringBootTest
public class MessageProducerTest {

    @Autowired
    private MessageProducer sender;

    @Test
    public void syncSend(){
        sender.syncSend();
    }

    @Test
    public void syncSendClustering(){
        sender.syncSendClustering();
    }

    @Test
    public void syncSendBroadcasting(){
        sender.syncSendBroadcasting();
    }

    @Test
    public void syncSendOrderly(){
        sender.syncSendOrderly();
    }

    @Test
    public void syncSendFilterBySql(){
        sender.syncSendFilterBySql();
    }

    @Test
    public void syncSendBatch(){
        sender.syncSendBatch();
    }

    @Test
    public void asyncSend() {
        sender.asyncSend();
    }

    @Test
    public void asyncSendOrderly() {
        sender.asyncSendOrderly();
    }

    @Test
    public void sendOneWay(){
        sender.sendOneWay();
    }

    @Test
    public void sendOneWayOrderly(){
        sender.sendOneWayOrderly();
    }

}
