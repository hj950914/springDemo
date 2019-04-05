package com.hj.ioc07;

import lombok.Data;

/**
 * Author: hj
 * Date: 2019-04-05 16:45
 * Description: <bean生命周期>
 */
@Data
public class SpringBean {

    private String name;

    private String sex;

    {
        System.out.println("代码块");
    }

    public SpringBean() {
        System.out.println("SpringBean实例化");
    }

    public void setName(String name) {
        System.out.println("SpringBean.setName");
        this.name = name;
    }

    //初始化方法（数据装配后执行这个方法）
    public void init() {
        this.name = this.name.toUpperCase() + "_" + this.sex.toUpperCase();
    }

    //销毁方法
    public void destory(){
        System.out.println("销毁方法");
    }
}