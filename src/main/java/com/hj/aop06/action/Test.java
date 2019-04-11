package com.hj.aop06.action;

import com.hj.aop06.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author: hj
 * Date: 2019-04-11 16:05
 * Description: <描述>
 */
public class Test {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("aop06/spring.xml");
        UserService userService = (UserService) ac.getBean("userService");
        userService.login("admin","123");
        userService.logout();
    }

}
