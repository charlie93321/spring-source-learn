package com.company.spring.model;

import lombok.Data;
import org.springframework.beans.factory.InitializingBean;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.List;

/**
 * @AUTHOR: 小于
 * @DATE: [2019/10/27  13:03]
 * @DESC:
 */
@Data
public class Depart implements InitializingBean {
    private Company company;
    private List<Person> personList;
    private String id;
    private String name;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("call afterPropertiesSet method ");
    }

    public void init(){
        System.out.println("call init method ");
    }

    public static Depart staticFactoryMethod() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz = Depart.class;
        Constructor construct=clazz.getConstructor(String.class);
        construct.setAccessible(true);
        Depart depart = (Depart) construct.newInstance("xx");
        depart.setPersonList(Collections.emptyList());
        return depart;
    }

    public Depart(String id){
        this.id = id;
    }
}
