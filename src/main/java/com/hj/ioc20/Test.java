package com.hj.ioc20;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

/**
 * Author: hj
 * Date: 2019-04-07 14:53
 * Description: <描述>
 */
public class Test {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("ioc20/spring.xml");
        System.out.println(ac.getBean("valentine"));
    }
}
