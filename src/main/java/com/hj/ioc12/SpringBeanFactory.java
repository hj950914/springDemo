package com.hj.ioc12;

/**
 * Author: hj
 * Date: 2019-04-06 15:45
 * Description: <实例工厂>
 */
public class SpringBeanFactory {

    public SpringBean getSpringBean(){
        return new SpringBean();
    }

    public SpringBean getSpringBean(String name){
        SpringBean springBean=new SpringBean();
        springBean.setName(name);
        return new SpringBean();
    }
}
