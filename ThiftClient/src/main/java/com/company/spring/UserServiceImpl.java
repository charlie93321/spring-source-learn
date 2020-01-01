package com.company.spring;

import com.alibaba.fastjson.JSON;
import org.apache.thrift.TException;
import thrift.user.User;
import thrift.user.UserInfo;

import java.util.HashMap;
import java.util.Map;

/**
 * @AUTHOR: 小于
 * @DATE: [2019/12/8  20:41]
 * @DESC:
 */
public class UserServiceImpl implements User.Iface {

    private Map<Integer, UserInfo> userInfoMap = new HashMap<>();


    @Override
    public UserInfo GetUser(int id) throws TException {
        UserInfo userInfo = new UserInfo();
        userInfoMap.put(id, userInfo);
        userInfo.setId(id);
        userInfo.setUsername("tom");
        userInfo.setPassword("123456");
        userInfo.setEmail("2459060612@qq.com");

        return userInfo;
    }

    @Override
    public String getName(int id) throws TException {
        return JSON.toJSONString(userInfoMap.get(id));
    }
}
