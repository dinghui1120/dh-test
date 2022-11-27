package com.dh.jdk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.dh")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
