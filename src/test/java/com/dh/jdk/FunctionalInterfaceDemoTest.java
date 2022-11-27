package com.dh.jdk;

import com.dh.jdk.entity.User;
import com.dh.jdk.lambda.FunctionalInterfaceDemo;
import com.dh.jdk.lambda.LambdaDemo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * 函数式接口
 * @author: dh
 * @date: 2022年11月27日
 **/
@SpringBootTest
public class FunctionalInterfaceDemoTest {

    @Test
    public void predicateTest() {
        List<User> users1 = FunctionalInterfaceDemo.predicate(LambdaDemo.defaultUserList, user -> user.getAge() > 20);
        users1.forEach(user -> System.out.println(user));
        System.out.println("-------------------------");
        List<User> users2 = FunctionalInterfaceDemo.predicate(LambdaDemo.defaultUserList, user -> user.getName().contains("明"));
        users2.forEach(user -> System.out.println(user));
    }

    @Test
    public void consumerTest() {
        User defaultUser = LambdaDemo.defaultUserList.get(0);
        FunctionalInterfaceDemo.consumer(defaultUser, user -> System.out.println(user));
        FunctionalInterfaceDemo.consumer(defaultUser, user -> {
            user.setSalary(user.getSalary() * 2);
            System.out.println(user);
        });
    }

    @Test
    public void supplierTest() {
        User user = FunctionalInterfaceDemo.supplier(() -> LambdaDemo.defaultUserList.get(0));
        System.out.println(user);
    }

    @Test
    public void functionTest() {
        Integer number = FunctionalInterfaceDemo.function(18, age -> age / 2 + 1);
        System.out.println(number);
    }

}
