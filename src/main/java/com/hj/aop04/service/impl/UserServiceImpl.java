package com.hj.aop04.service.impl;

import com.hj.aop04.service.UserService;

/**
 * Author: hj
 * Date: 2019-04-10 14:35
 * Description: <描述>
 */
public class UserServiceImpl implements UserService {

    @Override
    public void login(String username, String password) {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //int i=1/0;
        System.out.println("用户名:" + username + "密码:" + password);
    }

    @Override
    public void logout() {
        System.out.println("注销");
    }
}
