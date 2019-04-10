package com.hj.aop04.advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

/**
 * Author: hj
 * Date: 2019-04-10 16:59
 * Description: 前置通知,增强类
 */
public class LogAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        //日志打印
        System.out.println(method.getName() + "start at:" + new Date().getTime() + " args:" + Arrays.toString(args)
                + "target:" + target);
    }
}
