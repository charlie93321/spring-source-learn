package com.company.spring.factorybean;

import lombok.Data;

/**
 * @AUTHOR: 小于
 * @DATE: [2019/11/3  19:28]
 * @DESC:
 */
@Data
public class PersonFactory {

    private String id;
    private String name;



    /**
     * 获取T对象
     */
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

}
