package com.hj.ioc01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author: hj
 * Date: 2019-04-04 20:37
 * Description: <描述>
 */
public class Test {

    public static void main(String[] args) {
        //HelloSpring helloSpring=new HelloSpring();
        //helloSpring.show();

        //获取IOC容器,读取配置文件,初始化Spring上下文
        ApplicationContext ac=new ClassPathXmlApplicationContext("ioc01/applicationContext.xml");
        //根据id获取容器中的bean
        HelloSpring helloSpring=(HelloSpring) ac.getBean("helloSpring");
        helloSpring.show();
    }
}
