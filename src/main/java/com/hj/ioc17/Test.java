package com.hj.ioc17;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author: hj
 * Date: 2019-04-06 16:52
 * Description: <描述>
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("ioc17/applicationContext17.xml");
        SpringBean springBean=(SpringBean) ac.getBean("springBean");
        System.out.println(springBean.getOtherBean());
    }
}
