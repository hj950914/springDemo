package com.hj.ioc23;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author: hj
 * Date: 2019-04-07 17:07
 * Description: <描述>
 */
public class Test {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("ioc23/spring.xml");
        System.out.println(ac.getBean("springBean"));
        System.out.println(ac.getBean("otherBean"));
    }
}
