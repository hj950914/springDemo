package com.hj.aop04.action;

import com.hj.aop04.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author: hj
 * Date: 2019-04-10 16:57
 * Description: <描述>
 */
public class Test {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("aop04/spring.xml");
        UserService userService = (UserService) ac.getBean("userService");//拿到代理类
        System.out.println("代理类->>" + userService.getClass());

        userService.login("admin", "123");
        System.out.println("----------------------------------------");
        userService.logout();
    }
}
