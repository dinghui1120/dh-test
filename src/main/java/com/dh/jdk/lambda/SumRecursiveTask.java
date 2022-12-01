package com.dh.jdk.lambda;

import lombok.AllArgsConstructor;

import java.util.concurrent.RecursiveTask;

/**
 * Fork/Join
 * @author: dh
 * @date: 2022年11月27日
 **/
@AllArgsConstructor
public class SumRecursiveTask extends RecursiveTask<Long> {

    /**
     * 拆分的临界值
     */
    private static final Long THRESHOLD = 3000L;

    /**
     * 初始值
     */
    private Long start;

    /**
     * 结束值
     */
    private Long end;

    @Override
    protected Long compute() {
        long length = end - start;
        if (length <= THRESHOLD) {
            long sum = 0;
            for (long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        } else {
            long middle = (start + end) / 2;
            SumRecursiveTask left = new SumRecursiveTask(start, middle);
            left.fork();
            SumRecursiveTask right = new SumRecursiveTask(middle + 1, end);
            right.fork();
            return left.join() + right.join();
        }
    }

}
