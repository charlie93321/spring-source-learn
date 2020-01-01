package com.company.spring.iface;

import com.company.spring.model.User;

/**
 * @AUTHOR: 小于
 * @DATE: [2020/1/1  16:39]
 * @DESC:
 */
public interface UserService {

    public User register(String userName, String password,Integer age);


    public Boolean login(String userName, String password);


}
