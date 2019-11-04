package com.company.spring.bean.lookup;

import lombok.Data;

/**
 * @AUTHOR: 小于
 * @DATE: [2019/11/1  18:42]
 * @DESC:
 */
@Data
public  class Person {
    // 宠物
    private Animal animal;

    public  Animal getAnimal2(){return new Cat();};

    public Person(){

    }

    public void walking(){
       System.out.println("我有一个宠物,它是:"+getAnimal());
    }
}
