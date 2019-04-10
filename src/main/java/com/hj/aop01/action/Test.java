package com.hj.aop01.action;

import com.hj.aop01.service.impl.proxy.UserServiceProxy;
import com.hj.aop01.service.UserService;

/**
 * Author: hj
 * Date: 2019-04-10 14:37
 * Description: 静态代理
 */
public class Test {

    public static void main(String[] args) {
        //UserService userService=new UserServiceImpl();
        UserService userService = new UserServiceProxy();//代理类
        userService.login("admin", "123456");
        userService.logout();
    }
}
