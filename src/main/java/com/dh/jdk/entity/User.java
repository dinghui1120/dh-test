package com.dh.jdk.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户
 * @author: dh
 * @date: 2022年11月26日 18:30
 **/
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class User {

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 工资
     */
    private Double salary;

}
