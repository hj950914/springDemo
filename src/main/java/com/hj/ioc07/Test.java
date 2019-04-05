package com.hj.ioc07;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Author: hj
 * Date: 2019-04-05 16:50
 * Description: <bean 生命周期>
 */
public class Test {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("ioc07/applicationContext07.xml");
        SpringBean springBean = (SpringBean) ac.getBean("springBean");
        System.out.println(springBean.getName());

    }
}
