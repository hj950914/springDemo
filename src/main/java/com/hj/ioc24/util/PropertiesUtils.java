package com.hj.ioc24.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Author: hj
 * Date: 2019-04-09 19:29
 * Description: 读取properties属性文件的工具类
 */
public class PropertiesUtils {

    private static Properties ps;

    /*
     * 读取属性文件
     * */
    public static void loadind(InputStream inputStream) {
        if (ps == null) {
            ps = new Properties();
        }
        try {
            ps.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     * 获取属性值
     * */
    public static Object getValue(String key) {
        //如果key存在
        if (ps.containsKey(key)) {
            return ps.get(key);
        } else {
            throw new RuntimeException("属性文件中找不到" + key);
        }
    }

    /*
     * 判断是否是合法字符 ${}
     * */
    public static boolean matcher(String s) {
        //使用正则表达式
        Pattern pattern = Pattern.compile("\\$\\{(.*)\\}");
        return pattern.matcher(s).matches();
    }

    /*
     * 处理字符串
     * */
    public static String getKey(String s) {
        Pattern pattern = Pattern.compile("\\$\\{(.*)\\}");
        Matcher matcher = pattern.matcher(s);
        if (matcher.matches()) {
            return matcher.group(1);
        }
        throw new RuntimeException("格式不正确，string:" + s);
    }

}
