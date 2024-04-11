package com.dh.spi;

import org.springframework.core.annotation.Order;

/**
 * java
 * @author: dh
 * @date: 2024年03月24日
 **/
@Order(2)
public class JavaImpl implements ProgrammingLanguage{

    @Override
    public void study() {
        System.out.println("开始学习Java");
    }

}
