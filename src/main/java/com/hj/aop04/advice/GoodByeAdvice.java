package com.hj.aop04.advice;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * Author: hj
 * Date: 2019-04-11 12:15
 * Description: 后置通知,增强类
 */
public class GoodByeAdvice implements AfterReturningAdvice {

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("GoodByeAdvice,target"+target);
    }
}
