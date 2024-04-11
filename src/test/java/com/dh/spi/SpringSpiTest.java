package com.dh.spi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.core.io.support.SpringFactoriesLoader;

import java.util.List;

/**
 * SpringSpiTest
 * @author: dh
 * @date: 2024年03月24日
 **/
@SpringBootTest
public class SpringSpiTest {

    @Test
    public void applicationContextInitializerTest() {
        List<ApplicationContextInitializer> initializers = SpringFactoriesLoader.loadFactories(ApplicationContextInitializer.class, Thread.currentThread().getContextClassLoader());
        initializers.forEach(System.out::println);
    }

}
