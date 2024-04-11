package com.dh.spi;

import org.springframework.core.annotation.Order;

/**
 * python
 * @author: dh
 * @date: 2024年03月24日
 **/
@Order(1)
public class PythonImpl implements ProgrammingLanguage{

    @Override
    public void study() {
        System.out.println("开始学习Python");
    }

}
