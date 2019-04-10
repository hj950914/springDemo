package com.hj.ioc24;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author: hj
 * Date: 2019-04-09 15:24
 * Description: 关于数据装配的时候,进行类型装换
 */
public class Test {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("ioc24/spring.xml");
        SpringBean springBean = (SpringBean) ac.getBean("springBean");
        System.out.println(springBean);
    }
}
