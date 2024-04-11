package com.dh.spi.spring;

import com.dh.spi.ProgrammingLanguage;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.core.io.support.SpringFactoriesLoader;

import java.util.List;

/**
 * SpringSpiTest
 * @author: dh
 * @date: 2024年03月24日
 **/
public class SpringSpiTest {

    public static void main(String[] args) {
        programmingLanguage();
        //applicationContextInitializer();
    }

    public static void programmingLanguage() {
        List<ProgrammingLanguage> programmingLanguages = SpringFactoriesLoader.loadFactories(ProgrammingLanguage.class,
                Thread.currentThread().getContextClassLoader());
        for (ProgrammingLanguage loadBalance : programmingLanguages) {
            loadBalance.study();
        }
    }

    public static void applicationContextInitializer() {
        List<ApplicationContextInitializer> initializers = SpringFactoriesLoader.loadFactories(ApplicationContextInitializer.class,
                Thread.currentThread().getContextClassLoader());
        System.out.println(initializers.size());
        for (ApplicationContextInitializer initializer : initializers) {
            System.out.println(initializer);
        }
    }

}
