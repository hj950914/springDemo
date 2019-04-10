package com.hj.aop01.service.impl.proxy;

import com.hj.aop01.service.UserService;
import com.hj.aop01.service.impl.UserServiceImpl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * Author: hj
 * Date: 2019-04-10 14:40
 * Description: 静态代理类
 */
public class UserServiceProxy implements UserService {

    private UserService userService = new UserServiceImpl();

    @Override
    public void login(String username, String password) {
        //System.out.println("login start time:"+new Date().getTime());
        //userService.login(username, password);
        try {
            Method method = userService.getClass().getMethod("login", String.class, String.class);
            commons(method, username, password);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void logout() {
        //System.out.println("logout start time:"+new Date().getTime());
        //userService.logout();
        try {
            Method method=userService.getClass().getMethod("logout");
            commons(method);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    /*
     * 封装到公共方法中,统一入口,模块化
     * */
    public Object commons(Method method, Object... args) {
        //1.打印日志
        System.out.println(method.getName() + " 启动 time:" + new Date().getTime());
        //2.执行业务
        try {
            return method.invoke(userService, args);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
