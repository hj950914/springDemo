package com.hj.ioc20;


import lombok.Data;
import org.springframework.beans.factory.FactoryBean;

import java.util.Calendar;
import java.util.Date;

/**
 * Author: hj
 * Date: 2019-04-07 14:35
 * Description: 用来生成Date实例的FactoryBean
 */
@Data
public class DataFactoryBean implements FactoryBean<Date> {
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    private int second;

    @Override
    public Date getObject() {
        Calendar calendar = Calendar.getInstance();
        //设置时间
        calendar.set(this.year, this.month, this.day, this.hour, this.minute, this.second);
        Date date = calendar.getTime();
        return date;
    }

    //指定类返回的类型,由于泛型已经定义,这里可以不用管
    @Override
    public Class<?> getObjectType() {
        return null;
    }

    //是否单例
    @Override
    public boolean isSingleton() {
        return false;
    }
}
