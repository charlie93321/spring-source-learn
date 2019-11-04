package com.company.spring.model;

import lombok.Data;

/**
 * @AUTHOR: 小于
 * @DATE: [2019/10/27  13:03]
 * @DESC:
 */
@Data
public class Person {
    private String id;
    private String name;
    private String work;
    private Long slary;
    private Depart depart;
    private Company company;
}
