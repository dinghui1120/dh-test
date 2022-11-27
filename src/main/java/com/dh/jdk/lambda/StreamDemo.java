package com.dh.jdk.lambda;

import com.dh.jdk.entity.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream
 * @author: dh
 * @date: 2022年11月27日
 **/
public class StreamDemo {

    /**
     * map
     * @param userList
     * @return
     */
    public static List<String> map(List<User> userList) {
        List<String> list = userList.stream()
                .map(User::getName)
                .collect(Collectors.toList());
        return list;
    }

    /**
     * map
     * 给定单词列表["Hello","World"]
     * 返回列表["H","e","l", "o","W","r","d"]
     * map 生成的是个 1:1 映射，每个输入元素，都按照规则转换成为另外一个元素。
     * 还有一些场景，是一对多映射关系的，这时需要 flatMap
     * flatMap 把 input Stream 中的层级结构扁平化，就是将最底层元素抽出来放到一起
     * 最终 output 的新 Stream 里面已经没有 List 了，都是直接的数字
     */
    public static void flatMap() {
        List<String> words = Arrays.asList("Hello", "World");
        List<String[]> strings1 = words.stream()
                .map(word -> word.split(""))
                .distinct()
                .collect(Collectors.toList());
        strings1.forEach(str -> System.out.println(Arrays.toString(str)));
        System.out.println("--------------------------------------------");
        words = Arrays.asList("Hello", "World");
        List<String> strings2 = words.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(strings2);
    }

    /**
     * filter
     * @param userList
     * @return
     */
    public static List<User> filter(List<User> userList) {
        List<User> list = userList.stream()
                .filter(user -> user.getAge() > 20)
                .collect(Collectors.toList());
        return list;
    }

    /**
     * distinct
     * @param userList
     * @return
     */
    public static List<Double> distinct(List<User> userList) {
        List<Double> list = userList.stream()
                .map(User::getSalary)
                .distinct()
                .collect(Collectors.toList());
        return list;
    }

    /**
     * sorted
     * @param userList
     * @return
     */
    public static List<Double> sorted(List<User> userList) {
        List<Double> list = userList.stream()
                .map(User::getSalary)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        return list;
    }

    /**
     * limit
     * @param userList
     * @return
     */
    public static List<Double> limit(List<User> userList) {
        List<Double> list = userList.stream()
                .map(User::getSalary)
                .distinct()
                .sorted()
                .limit(3)
                .collect(Collectors.toList());
        return list;
    }

    /**
     * skip
     * @param userList
     * @return
     */
    public static List<Double> skip(List<User> userList) {
        List<Double> list = userList.stream()
                .map(User::getSalary)
                .distinct()
                .sorted()
                .skip(3)
                .collect(Collectors.toList());
        return list;
    }

    /**
     * peek
     * @param userList
     * @return
     */
    public static void peek(List<User> userList) {
        Stream.of("one", "two", "three","four").filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());
    }

    /**
     * iterate
     * @param n
     */
    public static void iterate(long n) {
        Stream.iterate(0, i -> i + 2)
                .limit(n)
                .forEach(System.out::println);
    }

    /**
     * parallel
     * 给定正整数n，计算 1 + 2 + … n的和
     * @param n
     * @return
     */
    public static long parallel(long n) {
        return Stream.iterate(1L, i -> i + 1).limit(n).parallel().reduce(0L, Long::sum);
    }

    /**
     * toArray
     */
    public static void toArray() {
        List<String> list = Arrays.asList("Krishna", "Mahesh", "Kush");
        String[] strArray = list.stream()
                .filter(e -> e.startsWith("K"))
                .toArray(String[]::new);
        for(String s : strArray) {
            System.out.println(s);
        }
    }

    /**
     * reduce1
     * reduce(BinaryOperator<T> accumulator) reduce方法接收一个函数，这个函数有两个参数
     * 第一个参数 result ：初始值为集合中的第一个元素，后面为每次的累加计算结果 ；
     * 第二个参数 item ：遍历的集合中的每一个元素（从第二个元素开始，第一个被result使用了）
     */
    public static void reduce1() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Integer total = list.stream()
                .reduce((result, item) -> result + item)
                .get();
        System.out.println(total);
    }

    /**
     * reduce2
     * 参数1：T identity 为一个初始值（默认值） ，当集合为空时，就返回这个默认值，当集合不为空时，该值也会参与计算；
     * 参数2：BinaryOperator<T> accumulator 这个与一个参数的reduce相同。
     * 返回值：并非 Optional，由于有默认值 identity ，因此计算结果不存在空指针的情况
     */
    public static void reduce2() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Integer total = list.stream().reduce(0, (result, item) -> result + item);
        System.out.println(total);
        list = new ArrayList<>();
        total = list.stream().reduce(0, (result, item) -> result + item);
        //数组为空时，结果返回默认值0
        System.out.println(total);
    }




    public static void main(String[] args) {
        System.out.println(sorted(LambdaDemo.defaultUserList));
        System.out.println(parallel(5));
        flatMap();
    }



}
