package com.hj.aop06.service.impl;

import com.hj.aop06.service.UserService;

/**
 * Author: hj
 * Date: 2019-04-10 14:35
 * Description: <描述>
 */
public class UserServiceImpl implements UserService {

    @Override
    public void login(String username, String password) {
        //int i=1/0;
        System.out.println("用户名:" + username + "密码:" + password);
    }

    @Override
    public void logout() {
        System.out.println("注销");
    }
}
