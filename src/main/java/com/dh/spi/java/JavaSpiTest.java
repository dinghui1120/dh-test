package com.dh.spi.java;

import com.dh.spi.ProgrammingLanguage;

import java.sql.Driver;
import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * JavaSpiTest
 * @author: dh
 * @date: 2024年03月24日
 **/
public class JavaSpiTest {

    public static void main(String[] args) {
        programmingLanguage();
        driver();
    }

    public static void programmingLanguage() {
        ServiceLoader<ProgrammingLanguage> serviceLoader = ServiceLoader.load(ProgrammingLanguage.class);
        Iterator<ProgrammingLanguage> iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
            ProgrammingLanguage service = iterator.next();
            service.study();
        }
    }

    public static void driver() {
        ServiceLoader<Driver> serviceLoader = ServiceLoader.load(Driver.class);
        Iterator<Driver> iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
            Driver driver = iterator.next();
            System.out.println(driver.getClass().getProtectionDomain());
        }
    }

}
