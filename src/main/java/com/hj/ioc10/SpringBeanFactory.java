package com.hj.ioc10;

/**
 * Author: hj
 * Date: 2019-04-06 15:11
 * Description: <静态工厂>
 */
public class SpringBeanFactory {

    public static SpringBean getSpringBean(){
        return new SpringBean();
    }

    public static SpringBean getSpringBean(String name){
        SpringBean springBean=new SpringBean();
        springBean.setName(name);
        return springBean;
    }
}
