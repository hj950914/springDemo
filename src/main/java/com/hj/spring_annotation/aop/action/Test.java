package com.hj.spring_annotation.aop.action;

import com.hj.spring_annotation.aop.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author: hj
 * Date: 2019-04-22 14:15
 * Description: <描述>
 */
public class Test {

    public static void main(String[] args) {
        ApplicationContext ac= new ClassPathXmlApplicationContext("spring_annotation/aop/spring.xml");
        UserService userService = (UserService) ac.getBean("userService");

        userService.login("admin","123");
        userService.logout();

        System.out.println(userService.getClass());

    }
}
