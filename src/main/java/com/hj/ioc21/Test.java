package com.hj.ioc21;


import lombok.Data;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

/**
 * Author: hj
 * Date: 2019-04-07 15:27
 * Description: <Resource类>
 */
@Data
public class Test {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("ioc21/spring.xml");
        SpringBean springBean=(SpringBean) ac.getBean("springBean");
        Resource resource=springBean.getResource();
        //实例工厂获取Resource对象
        //Resource resource=(Resource) ac.getBean("resource");
        System.out.println(resource.getFilename());
        System.out.println(resource.getDescription());
    }

}
