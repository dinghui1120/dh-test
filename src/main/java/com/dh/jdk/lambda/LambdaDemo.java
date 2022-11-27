package com.dh.jdk.lambda;

import com.dh.jdk.entity.User;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * LambdaDemo
 * @author: dh
 * @date: 2022年11月26日
 **/
public class LambdaDemo {

    public static List<User> defaultUserList = Arrays.asList(
            new User("小明", 16, 100.00),
            new User("小海", 20, 600.00),
            new User("小陆", 22, 700.00),
            new User("小空", 24, 800.00),
            new User("小地", 26, 100.00),
            new User("小张", 17, 200.00),
            new User("小兰", 18, 300.00),
            new User("小宇", 28, 2000.00)
    );

    /**
     * 对用户按年龄降序排序
     * java7
     */
    public static void userSortJava7() {
        defaultUserList.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o2.getAge() - o1.getAge();
            }
        });
        for (User user : defaultUserList) {
            System.out.println(user);
            System.out.println("Hello World");
        }
    }

    /**
     * 对用户按年龄降序排序
     * java8
     */
    public static void userSortJava8() {
        defaultUserList.sort((o1, o2) -> o2.getAge() - o1.getAge());
        defaultUserList.forEach(user -> System.out.println(user));
    }


}
