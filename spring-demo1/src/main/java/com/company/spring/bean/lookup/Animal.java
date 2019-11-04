package com.company.spring.bean.lookup;

import lombok.Data;

/**
 * @AUTHOR: 小于
 * @DATE: [2019/11/1  18:39]
 * @DESC:
 */
@Data
public class Animal {
    protected String id;
    protected String name;
    protected void bark(){
        System.out.println(this.id+" is barking ...");
    }
}
