package com.company.spring.bean.lookup;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

/**
 * @AUTHOR: 小于
 * @DATE: [2019/11/1  21:58]
 * @DESC:
 */
public class ReplaceMethod implements MethodReplacer {
    @Override
    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
        Cat cat = new Cat();
        cat.setId("id");
        cat.setName("TOMCAT");
        System.out.println("I am replace method");
        return cat;
    }
}
