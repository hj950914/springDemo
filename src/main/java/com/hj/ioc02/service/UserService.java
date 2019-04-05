package com.hj.ioc02.service;

import com.hj.ioc02.entity.User;

/**
 * Author: hj
 * Date: 2019-04-05 00:29
 * Description: <描述>
 */
public interface UserService {

    //用户登录
    public boolean login(String username,String password);
}
