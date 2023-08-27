package com.dh.rocketmq.listener;

import cn.hutool.core.date.DateUtil;
import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.springframework.messaging.Message;

import java.util.Date;

/**
 * 用于监听本地事务执行的状态和检查本地事务状态
 **/
@RocketMQTransactionListener
public class TransactionMsgListener implements RocketMQLocalTransactionListener {


    @Override
    public RocketMQLocalTransactionState executeLocalTransaction(Message msg, Object arg) {
        System.out.println("执行本地事务,msg:" + msg);
        System.out.println("执行本地事务,arg:" + arg);
        return RocketMQLocalTransactionState.UNKNOWN;
    }

    @Override
    public RocketMQLocalTransactionState checkLocalTransaction(Message msg) {
        System.out.println("检查本地事务,msg:" + msg);
        System.out.println("检查本地事务,当前时间:" + DateUtil.formatDateTime(new Date()));
        return RocketMQLocalTransactionState.UNKNOWN;
    }

}
