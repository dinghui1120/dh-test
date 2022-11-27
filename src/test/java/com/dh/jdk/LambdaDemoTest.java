package com.dh.jdk;

import com.dh.jdk.lambda.LambdaDemo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author: dh
 * @date: 2022年11月26日
 **/
@SpringBootTest
public class LambdaDemoTest {

    @Test
    public void test1() {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World");
            }
        });
        thread1.start();
        Thread thread2 = new Thread(() -> System.out.println("Hello World"));
        thread2.start();
    }

    @Test
    public void userSortJava7() {
        LambdaDemo.userSortJava7();
    }

    @Test
    public void userSortJava8() {
        LambdaDemo.userSortJava8();
    }

}
