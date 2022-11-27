package com.dh.jdk.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 函数式接口
 * @author: dh
 * @date: 2022年11月27日
 **/
public class FunctionalInterfaceDemo {

    /**
     * Predicate
     * @param list
     * @param predicate
     * @return
     */
    public static <T> List<T> predicate(List<T> list, Predicate<T> predicate) {
        List<T> newList = new ArrayList<>();
        for (T t : list) {
            if (predicate.test(t)) {
                newList.add(t);
            }
        }
        return newList;
    }

    /**
     * Consumer
     * @param t
     * @param consumer
     */
    public static <T> void consumer(T t, Consumer<T> consumer) {
        consumer.accept(t);
    }

    /**
     * Supplier
     * @param supplier
     * @return
     */
    public static <T> T supplier(Supplier<T> supplier) {
        return supplier.get();
    }

    /**
     * function
     * @param t
     * @param function
     * @return
     */
    public static <T, R> R function(T t, Function<T, R> function) {
        return function.apply(t);
    }


}
