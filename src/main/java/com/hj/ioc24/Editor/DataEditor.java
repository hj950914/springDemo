package com.hj.ioc24.Editor;


import java.beans.PropertyEditorSupport;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author: hj
 * Date: 2019-04-09 17:23
 * Description: Data属性转换器
 */
public class DataEditor extends PropertyEditorSupport {

    //对象转字符串
    @Override
    public String getAsText() {
        System.out.println("getAsText");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format((Date) getValue());
    }

    //字符串转对象
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        System.out.println("setAsText");
        //设置日期格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(text);
            //将对象存入ioc容器
            setValue(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

