package com.dh.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.dh.test")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
