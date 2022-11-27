package com.dh.jdk.lambda;

import com.dh.jdk.entity.User;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用
 * @author: dh
 * @date: 2022年11月27日
 **/
public class MethodReferenceDemo {

    /**
     * 类::静态方法
     */
    public static void classStaticMethod() {
        LambdaDemo.defaultUserList.sort((o1, o2) -> o2.getAge() - o1.getAge());
        LambdaDemo.defaultUserList.sort(MethodReferenceDemo::compare);
        Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);
        Comparator<Integer> method = Integer::compare;
    }

    /**
     * 类::实例方法
     * Lambda 参数列表的第一个参数，是实例方法的调用者，第二个参数(或无参)是实例方法的参数
     */
    public static void classInstanceMethod() {
        Function<User, String> function = user -> user.getName();
        Function<User, String> method = User::getName;
        String name = method.apply(LambdaDemo.defaultUserList.get(0));
        System.out.println(name);
    }

    /**
     * 对象::实例方法
     */
    public static void objectInstanceMethod() {
        LambdaDemo.defaultUserList.forEach(user -> System.out.println(user));
        LambdaDemo.defaultUserList.forEach(System.out::println);
    }

    /**
     * 构造器引用
     * 类::new
     */
    public static void constructorReference() {
        Supplier<User> supplier = () -> new User();
        Supplier<User> method = User::new;
        User user = method.get();
        System.out.println(user);
    }

    /**
     * 数组引用
     * 数组类型[] :: new
     */
    public static void arrayReference() {
        Function<Integer,String[]> fun1 = len -> new String[len];
        Function<Integer,String[]> fun2 = String[]::new;
        String[] strArr = fun2.apply(12);
        System.out.println(strArr.length);
    }

    private static int compare(User o1, User o2) {
        return o2.getAge() - o1.getAge();
    }

}
