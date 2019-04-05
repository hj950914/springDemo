package com.hj.ioc02.action;

import com.hj.ioc02.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author: hj
 * Date: 2019-04-05 00:37
 * Description: <描述>
 */
public class Test {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("ioc02/applicationContext02.xml");
        UserService userService = (UserService) ac.getBean("userServices");
        boolean flag=userService.login("admin","123");
        if (flag){
            System.out.println("success");
        }else {
            System.out.println("false");
        }
    }

}
