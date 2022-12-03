package com.dh.jdk.lambda;

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

}
