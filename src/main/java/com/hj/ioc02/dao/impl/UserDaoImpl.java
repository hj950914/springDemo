package com.hj.ioc02.dao.impl;

import com.hj.ioc02.dao.UserDao;
import com.hj.ioc02.entity.User;

/**
 * Author: hj
 * Date: 2019-04-05 00:26
 * Description: <描述>
 */
public class UserDaoImpl implements UserDao {

    //根据用户名查找用户
    @Override
    public User selectByUsername(String username) {
        System.out.println("使用JDBC查找");
        User user=new User();
        user.setUsername("admin");
        user.setPassword("123");
        return user;
    }
}
