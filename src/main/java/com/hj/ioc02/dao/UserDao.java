package com.hj.ioc02.dao;

import com.hj.ioc02.entity.User;

/**
 * Author: hj
 * Date: 2019-04-05 00:24
 * Description: <描述>
 */
public interface UserDao {

    //根据用户名查找用户
    public User selectByUsername(String username);
}
