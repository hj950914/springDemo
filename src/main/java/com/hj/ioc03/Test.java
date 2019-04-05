package com.hj.ioc03;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * Author: hj
 * Date: 2019-04-05 14:53
 * Description: <IOC容器的类型>
 */
public class Test {

    public static void main(String[] args) {

        /*
        * ApplicationContext
        * */
        //第一种:通过ClassPathXmlApplicationContext加载ioc容器
        ApplicationContext ac=new ClassPathXmlApplicationContext("ioc03/applicationContext03.xml");
        SpringBean springBean=(SpringBean) ac.getBean("springBean");
        System.out.println(springBean);

        //第二种:通过系统路径FileSystemXmlApplicationContext加载ioc容器
        //ApplicationContext ac2=new FileSystemXmlApplicationContext("系统路径");

        /*
        * BeanFactory
        * */
        //第一种:通过XmlBeanFactory加载ioc容器
        Resource resource=new ClassPathResource("ioc03/applicationContext03.xml");
        BeanFactory bf=new XmlBeanFactory(resource);
        SpringBean springBean1=(SpringBean) bf.getBean("springBean");
        System.out.println(springBean1);

    }
}
