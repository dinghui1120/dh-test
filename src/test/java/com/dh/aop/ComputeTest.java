package com.dh.aop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

/**
 * @author: dh
 * @date: 2024年12月01日 18:18
 **/
@SpringBootTest
public class ComputeTest {

    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void test() {
        Compute compute = new ComputeImpl();
        System.out.println(compute.add(1, 5));
        System.out.println(compute.subtract(1, 5));
        System.out.println(compute.multiply(1, 5));
        System.out.println(compute.divide(1, 5));
    }

    @Test
    public void testLogging() {
        Compute compute = new ComputeLoggingImpl();
        System.out.println(compute.add(1, 5));
        System.out.println(compute.subtract(1, 5));
        System.out.println(compute.multiply(1, 5));
        System.out.println(compute.divide(1, 5));
    }

    @Test
    public void testJdkProxy() {
        Compute compute = new ComputeImpl();
        Compute proxy = new ComputeLoggingProxy(compute).getLoggingProxy();
        System.out.println(proxy.add(1, 5));
        System.out.println(proxy.subtract(1, 5));
        System.out.println(proxy.multiply(1, 5));
        System.out.println(proxy.divide(1, 5));
    }

    @Test
    public void testAop() {
        Compute compute = (Compute) applicationContext.getBean("computeImpl");
        System.out.println(compute.getClass().getName());
        System.out.println(compute.add(1, 5));
        System.out.println(compute.subtract(1, 5));
        System.out.println(compute.multiply(1, 5));
        System.out.println(compute.divide(1, 5));
    }

}
