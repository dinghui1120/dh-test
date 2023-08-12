package com.dh.jdk.lambda;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjuster;

/**
 *
 * @author: dh
 * @date: 2022年11月27日
 **/
public class DateTimeApiDemo {

    public static void TemporalAdjuster() {
        LocalDateTime now = LocalDateTime.now();
        //此处 Temporal 就是指时间(包括 LocalDate、LocalTime、LocalDateTime 都是继承自该类)
        TemporalAdjuster adjuster = temporal -> {
            LocalDateTime dateTime = (LocalDateTime) temporal;
            return dateTime.plusMonths(1).withDayOfMonth(1);
        };
        LocalDateTime newDateTime = now.with(adjuster);
        System.out.println("下个月第一天:"+newDateTime);
    }

    public static void test() {
        //获取当前日期
        LocalDate now = LocalDate.now();
        LocalDate date = LocalDate.of(2008, 8, 8);
        System.out.println("年:" + date.getYear());
        System.out.println("月(英文):" + date.getMonth());
        System.out.println("月(数字):" + date.getMonthValue());
        System.out.println("日:" + date.getDayOfMonth());
        System.out.println("是否是闰年:" + date.isLeapYear());
    }

    public static void main(String[] args) {
        test();
    }

}
