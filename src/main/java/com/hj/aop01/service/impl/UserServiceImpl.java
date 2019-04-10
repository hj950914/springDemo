package com.hj.aop01.service.impl;

import com.hj.aop01.service.UserService;

/**
 * Author: hj
 * Date: 2019-04-10 14:35
 * Description: <描述>
 */
public class UserServiceImpl implements UserService {

    @Override
    public void login(String username, String password) {
        System.out.println("用户名:" + username + "密码:" + password);
    }

    @Override
    public void logout() {
        System.out.println("注销");
    }
}
