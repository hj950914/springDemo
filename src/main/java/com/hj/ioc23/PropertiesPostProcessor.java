package com.hj.ioc23;

import lombok.Data;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.io.Resource;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Author: hj
 * Date: 2019-04-07 17:12
 * Description: bean的后置处理器
 */
@Data
public class PropertiesPostProcessor implements BeanPostProcessor {

    private Resource resource;

    //初始化方法之后执行
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class c = bean.getClass();
        //获取成员变量
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            String name = field.getName();//获取变量名
            //只对String类型有效
            if (field.getType() == String.class) {
                try {
                    Method method = c.getMethod("get" + StringUtils.capitalize(name));
                    String str = (String) method.invoke(bean);//通过get方法获取值
                    String value = reValue(str);//字符截取${}
                    method = c.getMethod("set" + StringUtils.capitalize(name), String.class);
                    method.invoke(bean, value);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return bean;
    }

    //传入${value},去除${}
    private String reValue(String str) {
        //为空返回
        if (str == null && str.equals("")) {
            return str;
        }
        /*
         * 去除${}
         * 方式1
         * */
        /*if (str.startsWith("${") && str.endsWith("}")) {
            //取子串，${1} -> 1,获取值
            String key = str.substring(2, str.length() - 1);
            return getValues(key);//从属性文件里查找值
        } else {
            return str;
        }*/



        /*
         * 方式2:使用正则表达式
         * */
        Pattern pattern = Pattern.compile("\\$\\{(.*)}");
        Matcher matcher = pattern.matcher(str);
        if (matcher.matches()) {
            String key = matcher.group(1);
            return getValues(key);
        }

        return str;
    }

    /*
     *   传入key,从properties属性文件里面查找对应的value
     * */
    private String getValues(String key) {

        Properties ps = new Properties();
        try {
            ps.load(resource.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        //如果key存在
        if (ps.containsKey(key)) {
            return ps.getProperty(key);
        } else {
            throw new RuntimeException(key + "在属性文件里面没有找到!");
        }

    }

    //初始化方法之前执行
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
