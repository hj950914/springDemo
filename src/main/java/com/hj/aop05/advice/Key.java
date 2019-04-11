package com.hj.aop05.advice;

import lombok.Data;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;

/**
 * Author: hj
 * Date: 2019-04-11 14:56
 * Description: 自定义key
 * 用来封装判断方法是否执行的三个要素:method,orgs,target
 */
@Data
public class Key {

    private Method method;

    private Object[] args;

    private Object target;

    @Override
    public boolean equals(Object o) {
        //判断是否同一对象
        if (this == o) {
            return true;
        }
        //判断是否为同一类型
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        //判断内容是否相同
        Key key = (Key) o;
        return key.getMethod().equals(this.getMethod()) &&
                Arrays.equals(key.getArgs(), this.getArgs()) && key.getTarget() == this.getTarget();
    }

    @Override
    public int hashCode() {
        int result = method != null ? method.hashCode() : 0;
        result = 31*result + Arrays.hashCode(args);
        result = 31*result + (target != null ? target.hashCode() : 0);
        return result;
    }
}
