package com.hj.aop05.action;

import com.hj.aop05.service.CaluService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author: hj
 * Date: 2019-04-11 14:13
 * Description: <描述>
 */
public class Test {

    @org.junit.jupiter.api.Test
    public void test() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("aop05/spring.xml");
        CaluService caluService = (CaluService) ac.getBean("caluService");
        System.out.println(caluService.add(1, 2));
        System.out.println(caluService.add(1, 2));
        System.out.println(caluService.add(2, 1));
        System.out.println(caluService.sub(1, 2));
        System.out.println(caluService.sub(1, 2));
        System.out.println(caluService.sub(2, 1));
    }
}
