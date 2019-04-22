package com.hj.spring_annotation.aop.service.impl;

import com.hj.spring_annotation.aop.service.UserService;
import org.springframework.stereotype.Service;

/**
 * Author: hj
 * Date: 2019-04-10 14:35
 * Description: <描述>
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Override
    public void login(String username, String password) {
        //int i = 1/0;
        System.out.println("用户名:" + username + "密码:" + password);
    }

    @Override
    public void logout() {
        System.out.println("注销");
    }
}
