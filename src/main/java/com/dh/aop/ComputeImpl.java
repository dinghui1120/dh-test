package com.dh.aop;

import org.springframework.stereotype.Component;

/**
 * @author: dh
 * @date: 2024年12月01日
 **/
@Component
public class ComputeImpl implements Compute {

    @Override
    public int add(int i, int j) {
        int result = i + j;
        return result;
    }

    @Override
    public int subtract(int i, int j) {
        int result = i - j;
        return result;
    }

    @Override
    public int multiply(int i, int j) {
        int result = i * j;
        return result;
    }

    @Override
    public int divide(int i, int j) {
        j = 0;
        int result = i / j;
        return result;
    }

}
