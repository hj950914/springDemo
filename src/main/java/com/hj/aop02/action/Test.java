package com.hj.aop02.action;

import com.hj.aop02.service.UserService;
import com.hj.aop02.service.impl.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Date;

/**
 * Author: hj
 * Date: 2019-04-10 14:37
 * Description: 动态代理
 */
public class Test {


    @org.junit.jupiter.api.Test
    void test() {
        //调用Proxy类的newProxyInstance()方法动态的生成代理类和实例
        UserService userService = (UserService) Proxy.newProxyInstance(
                UserServiceImpl.class.getClassLoader(),//目标类的类加载器
                new Class[]{UserService.class},//目标类的接口列表
                (proxy, method, args1) -> {//交叉业务逻辑
                    //1.打印日志
                    System.out.println(method.getName() + "start time:" + new Date().getTime());
                    //2.执行业务
                    return method.invoke(new UserServiceImpl(), args1);
                }
        );
        System.out.println("类的类类型" + userService.getClass());
        userService.login("admin", "123456");
        userService.logout();
    }
}
