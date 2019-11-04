package com.company.spring.factorybean;

import lombok.Data;

/**
 * @AUTHOR: 小于
 * @DATE: [2019/11/3  18:00]
 * @DESC:
 */
@Data
public abstract class Person {
    private String id;
    private String name;
    public abstract void walk();
}
