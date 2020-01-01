package com.company.spring.iface;

import com.company.spring.model.User;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @AUTHOR: 小于
 * @DATE: [2020/1/1  16:39]
 * @DESC:
 */

@Service
public class UserServiceImpl implements UserService {


    private List<User> contextList = new ArrayList<>();

    public User register(String userName, String password, Integer age) {
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        contextList.add(user);
        return user;
    }


    public Boolean login(String userName, String password) {

        if (CollectionUtils.isNotEmpty(contextList)) {

            for (User user : contextList) {
                if (StringUtils.equals(user.getUserName(), userName) && StringUtils.equals(user.getPassword(), password)) {
                    return true;
                }
            }
        }
        return false;
    }


}
