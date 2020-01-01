package com.company.spring.circle;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @AUTHOR: 小于
 * @DATE: [2019/11/10  10:28]
 * @DESC:
 */
@Component
@Data
public class UserService {
    @Autowired
    private IndexService indexService;

    public UserService() {
        System.out.println("userservice call new UserService();");
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("userservice call postConstruct");
    }
}
