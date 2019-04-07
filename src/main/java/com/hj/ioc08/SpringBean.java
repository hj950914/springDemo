package com.hj.ioc08;

import lombok.Data;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Author: hj
 * Date: 2019-04-05 17:17
 * Description: <描述>
 */
@Data
public class SpringBean {

    private String username;

    private String password;

    private String email;

    private String photo;

    private int age;

    //初始化
    public void init() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        /*
         * 使用反射动态获取属性,然后重新赋值
         * */
        Class c = this.getClass();
        //获取成员变量
        Field[] fields = c.getDeclaredFields();
        for (Field f : fields) {
            Class type = f.getType();//获取属性类型
            //判断类型是否为String,这里只对String进行操作
            if (type == String.class) {
                String name = f.getName();//获取属性名,例如username
                //获取getXXX方法,再调用invoke方法获取属性的值
                Method methodGet = c.getMethod("get" + StringUtils.capitalize(name));
                String str = (String) methodGet.invoke(this);
                //调用reValue方法
                String value = reValue(str);
                //调用setXXX方法为属性赋值
                Method methodSet = c.getMethod("set" + StringUtils.capitalize(name), String.class);
                //把从getXXX获取到的进行赋值
                methodSet.invoke(this, value);
            }
        }

    }

    //现在传过来的是 ${值} 这种形式,取出里面的值在properties属性文件里面找
    private String reValue(String value) {
        //判断是否为空
        if (value == null || "".equals(value)) {
            return value;
        }
        //方式1:字符串截取（如果是${}这种格式）
        /*if (value.startsWith("${") && value.endsWith("}")) {
            //取出中间的key值,然后去properties属性文件里面找
            String key = value.substring(2, value.length() - 1);
            //通过key获取value值
            return getValues(key);
        }*/
        //方式2：使用正则表达式
        Pattern pattern = Pattern.compile("\\$\\{(.*)}");
        Matcher matcher = pattern.matcher(value);
        //判断是否匹配
        if (matcher.matches()) {
            String key = matcher.group(1);
            return getValues(key);
        }

        return value;
    }

    //通过key获取value值
    private String getValues(String key) {
        Properties p = new Properties();
        try {
            //读取properties文件
            p.load(SpringBean.class.getClassLoader().getResourceAsStream("ioc08/info.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //判断key是否存在
        if (p.containsKey(key)) {
            return p.getProperty(key);
        } else {
            throw new RuntimeException(key + "没找到");
        }
    }
}
