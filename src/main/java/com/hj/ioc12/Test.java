package com.hj.ioc12;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author: hj
 * Date: 2019-04-06 15:45
 * Description: <描述>
 */
public class Test {

    public static void main(String[] args) {

        //不使用spring
/*        SpringBeanFactory springBeanFactory=new SpringBeanFactory();
        SpringBean springBean=springBeanFactory.getSpringBean();*/


        ApplicationContext ac = new ClassPathXmlApplicationContext("ioc12/applicationContext12.xml");
        SpringBean springBean=(SpringBean) ac.getBean("springBean2");
        System.out.println(springBean);
    }
}
