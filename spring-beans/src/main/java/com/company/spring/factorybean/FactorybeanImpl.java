package com.company.spring.factorybean;

import lombok.Data;
import org.springframework.beans.factory.FactoryBean;

/**
 * @AUTHOR: 小于
 * @DATE: [2019/11/3  17:27]
 * @DESC:
 */
@Data
public class FactorybeanImpl implements FactoryBean<Person>{

    private String id;
    private String name;



    /**
     * 获取T对象
     */
    @Override
    public Person getObject() throws Exception {

        Person person = new Person() {
            @Override
            public void walk() {
                System.out.println("I am walking in the street...:{'id':"+id+",'name':"+name+"}");
            }
        };
        person.setId(id);
        person.setName(name);
        return person;
    }

    /**
     * 获取T对象的类
     * @return
     */
    @Override
    public Class<?> getObjectType() {
        return Person.class;
    }


    /**
     * 是否是单例对象
     * @return
     */
    @Override
    public boolean isSingleton() {
        return true;
    }
}
