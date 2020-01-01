package com.company.spring.circle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @AUTHOR: 小于
 * @DATE: [2019/11/10  10:29]
 * @DESC:
 */
@Component
public class IndexService {
    @Autowired
    private UserService userService;


    public IndexService() {

        System.out.println("IndexService call new IndexService();");

    }


    @PostConstruct
    public void postConstruct() {
        System.out.println("IndexService call postConstruct");
    }
}
