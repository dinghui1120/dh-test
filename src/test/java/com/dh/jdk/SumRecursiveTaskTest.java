package com.dh.jdk;

import com.dh.jdk.lambda.SumRecursiveTask;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.ForkJoinPool;

/**
 * Fork/Join
 * @author: dh
 * @date: 2022年11月27日
 **/
@SpringBootTest
public class SumRecursiveTaskTest {

    @Test
    public void sumRecursiveTask() {
        long start = System.currentTimeMillis();
        ForkJoinPool pool = new ForkJoinPool();
        SumRecursiveTask task = new SumRecursiveTask(1L, 1000000000L);
        Long result = pool.invoke(task);
        System.out.println("result=" + result);
        long end = System.currentTimeMillis();
        System.out.println("耗时:" + (end - start));
    }

}
