package com.dh.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author: dh
 * @date: 2024年12月01日
 **/
public class ComputeLoggingProxy {

    //1、目标对象（被代理的对象）
    private Compute target;

    public ComputeLoggingProxy(Compute compute) {
        this.target = compute;
    }

    //2、定义一个方法，返回代理对象
    public Compute getLoggingProxy() {
        Compute proxy = null;
        ClassLoader classLoader = target.getClass().getClassLoader();
        Class[] interfaces = new Class[]{Compute.class};

        /**
         * 通过实现 InvocationHandler 接口，你可以动态地创建代理对象，
         * 这些代理对象可以在方法调用时执行额外的逻辑
         *
         * invoke 方法在每次调用代理对象的方法时被触发。你可以在 invoke 方法中添加额外的逻辑
         *
         * proxy：被代理的对象。
         * method：被调用的方法。
         * args：方法调用的参数数组。
         */
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //获取方法名
                Object result = null;
                String methodName = method.getName();
                //3、调用目标方法
                try {
                    //前置通知
                    System.out.println("日志管理-前置通知(" + methodName + "," + Arrays.toString(args) + ")");
                    result = method.invoke(target, args);
                    //返回值通知
                } catch (Exception e) {
                    //异常通知
                }finally {
                    //后置通知
                    System.out.println("日志管理-后置通知result:" + result);
                }
                return result;
            }
        };
        proxy = (Compute) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
        return proxy;
    }

}
