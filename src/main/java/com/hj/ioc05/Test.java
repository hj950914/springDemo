package com.hj.ioc05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author: hj
 * Date: 2019-04-05 16:03
 * Description: <描述>
 */
public class Test {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("ioc05/applicationContext05.xml");
        SpringBean springBean = (SpringBean) ac.getBean("springBean");
        //System.out.println(springBean.getOtherBean().getName());

        System.out.println(springBean);
    }

}
