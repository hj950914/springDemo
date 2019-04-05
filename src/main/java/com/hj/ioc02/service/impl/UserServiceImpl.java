package com.hj.ioc02.service.impl;

import com.hj.ioc02.dao.UserDao;
import com.hj.ioc02.entity.User;
import com.hj.ioc02.service.UserService;

/**
 * Author: hj
 * Date: 2019-04-05 00:30
 * Description: <描述>
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    //用户登录
    @Override
    public boolean login(String username, String password) {
        User user=userDao.selectByUsername(username);
        if (user!=null){
            return user.getPassword().equals(password);
        }
        return false;
    }
}
