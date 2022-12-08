package com.dh.jdk.lambda;

import com.dh.jdk.entity.User;

import java.util.*;
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
     * concat
     * @return
     */
    public static void concat() {
        Stream<Integer> stream1 = Stream.of(1,5,8,100,56);
        Stream<Integer> stream2 = Stream.of(10,50,80,1000,506);
        Stream.concat(stream1,stream2).forEach(System.out::println);
    }

    /**
     * peek
     * @return
     */
    public static void peek() {
        Stream.of("one", "two", "three","four")
                .filter(e -> e.length() > 3)
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
     * generate
     * @param n
     */
    public static void generate(long n) {
        Stream.generate(Math::random)
                .limit(5)
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

    /**
     * allMatch
     */
    public static void allMatch() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        boolean result = list.stream().allMatch(item -> item.equals(1));
        System.out.println(result);
    }

    /**
     * anyMatch
     */
    public static void anyMatch() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        boolean result = list.stream().anyMatch(item -> item.equals(1));
        System.out.println(result);
    }

    /**
     * noneMatch
     */
    public static void noneMatch() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        boolean result = list.stream().noneMatch(item -> item.equals(1));
        System.out.println(result);
    }

    /**
     * findFirst
     */
    public static void findFirst() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> optional = list.stream()
                .filter(item -> item > 2)
                .findFirst();
        System.out.println(optional.get());
    }

    /**
     * findAny
     */
    public static void findAny() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Optional<Integer> optional = list.parallelStream()
                .filter(item -> item > 2)
                .findAny();
        System.out.println(optional.get());
    }

    /**
     * 收集到集合中
     */
    public static void collectToList(List<User> list) {
        List<Integer> lists = list.stream()
                .map(User::getAge)
                .collect(Collectors.toList());

        Set<Integer> sets = list.stream()
                .map(User::getAge)
                .collect(Collectors.toSet());

        List<Integer> lists2 = list.stream()
                .map(User::getAge)
                .collect(Collectors.toCollection(LinkedList::new));

        Map<String, Double> map = list.stream()
                .collect(Collectors.toMap(User::getName, User::getSalary));
    }

    /**
     * groupingBy
     */
    public static void groupingBy(List<User> list) {
        //分组
        Map<String, List<User>> genderMap = list.stream()
                .collect(Collectors.groupingBy(User::getGender));
        genderMap.forEach((k, v) -> System.out.println(k + "\n" + v));
        System.out.println("-----------------------------------------");
        //多级分组
        Map<String, Map<String, List<User>>> userMap = list.stream()
                .collect(Collectors.groupingBy(User::getGender,
                        Collectors.groupingBy(user -> user.getAge() > 18 ? "成年" : "未成年")));
        userMap.forEach((k, v) -> System.out.println(k + "\n" + v));
    }

    /**
     * partitioningBy
     */
    public static void partitioningBy(List<User> list) {
        Map<Boolean, List<User>> userMap = list.stream()
                .collect(Collectors.partitioningBy(user -> user.getAge() > 18));
        userMap.forEach((k, v) -> System.out.println(k + "\n" + v));
    }

    /**
     * 对流中的数据做聚合计
     */
    public static void collectAggregate(List<User> list) {
        //总数
        Long counting = list.stream().collect(Collectors.counting());
        //求和
        list.stream().collect(Collectors.summarizingInt(User::getAge));

        list.stream().collect(Collectors.reducing(0,User::getAge,Integer::sum));

        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        list1.stream().reduce(0, (result, item) -> result + item);
        list1.stream().collect(Collectors.reducing(0, (result, item) -> result + item));
    }

    /**
     * joining
     */
    public static void joining(List<User> list) {
        String name1 = list.stream()
                .map(User::getName)
                .collect(Collectors.joining());
        System.out.println(name1);
        String name2 = list.stream()
                .map(User::getName)
                .collect(Collectors.joining(","));
        System.out.println(name2);
        String name3 = list.stream()
                .map(User::getName)
                .collect(Collectors.joining(",","^","$"));
        System.out.println(name3);
    }

    /**
     * collectingAndThen
     */
    public static void collectingAndThen(List<User> list) {
        //统计Map中的元素个数
        Integer collect = list.stream().collect(Collectors.collectingAndThen(Collectors.groupingBy(User::getGender), Map::size));
        System.out.println(collect);
        //统计的Map中的每个Value的数量
        Map<String, Long> collect1 = list.stream().collect(Collectors.groupingBy(User::getGender, Collectors.counting()));
        System.out.println(collect1);
    }

    /**
     * 1、Stream只能操作一次
     * 2、Stream不调用终结方法，中间的操作不会执行
     * 3、collectors.tomap key不能重复 ,key可以为null,但 value不能为null
     * 4、当list集合里某个元素的属性为空，并且你使用Collectors.groupingBy()方法对这个属性进行分组，这时系统会报错
     */
    public static void parallelStream() {

    }




    public static void main(String[] args) {
        System.out.println(sorted(LambdaDemo.defaultUserList));
        System.out.println(parallel(5));
        flatMap();
        allMatch();
        anyMatch();
        noneMatch();
        findFirst();
        findAny();
        concat();
        joining(LambdaDemo.defaultUserList);
        groupingBy(LambdaDemo.defaultUserList);
        partitioningBy(LambdaDemo.defaultUserList);
        collectingAndThen(LambdaDemo.defaultUserList);
    }



}
