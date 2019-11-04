package com.company.spring.model;

import lombok.Data;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;

/**
 * @AUTHOR: 小于
 * @DATE: [2019/11/1  17:42]
 * @DESC:
 */
@Data
public class DefaultFactory {

   private String id;
   private String name;
    public  Depart instanceFactoryMethod() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz = Depart.class;
        Constructor construct=clazz.getConstructor(String.class);
        construct.setAccessible(true);
        Depart depart = (Depart) construct.newInstance(id);
        depart.setName(name);
        depart.setPersonList(Collections.emptyList());
        return depart;
    }


}
