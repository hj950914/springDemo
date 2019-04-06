package com.hj.ioc10;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author: hj
 * Date: 2019-04-06 15:13
 * Description: <描述>
 */
public class Test {

    public static void main(String[] args) {
        //不使用spring
        //SpringBean springBean=SpringBeanFactory.getSpringBean();

        ApplicationContext ac = new ClassPathXmlApplicationContext("ioc10/applicationContext10.xml");

        SpringBean springBean=(SpringBean) ac.getBean("springBean2");
        System.out.println(springBean);
    }
}
