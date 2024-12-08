package com.dh.aop;

/**
 * @author: dh
 * @date: 2024年12月01日
 **/
public class ComputeLoggingImpl implements Compute {

    @Override
    public int add(int i, int j) {
        System.out.println("日志管理-前置通知(" + i + "," + j + ")");
        int result = i + j;
        System.out.println("日志管理-后置通知result:" + result);
        return result;
    }

    @Override
    public int subtract(int i, int j) {
        System.out.println("日志管理-前置通知(" + i + "," + j + ")");
        int result = i - j;
        System.out.println("日志管理-后置通知result:" + result);
        return result;
    }

    @Override
    public int multiply(int i, int j) {
        System.out.println("日志管理-前置通知(" + i + "," + j + ")");
        int result = i * j;
        System.out.println("日志管理-后置通知result:" + result);
        return result;
    }

    @Override
    public int divide(int i, int j) {
        System.out.println("日志管理-前置通知(" + i + "," + j + ")");
        int result = i / j;
        System.out.println("日志管理-后置通知result:" + result);
        return result;
    }

}
