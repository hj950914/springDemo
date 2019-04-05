package com.hj.ioc04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author: hj
 * Date: 2019-04-05 15:33
 * Description: <描述>
 */
public class Test {

    public static void main(String[] args) {
        ApplicationContext ac=new ClassPathXmlApplicationContext("ioc04/applicationContext04.xml");
        System.out.println(ac.getBean("springBean"));

    }
}
