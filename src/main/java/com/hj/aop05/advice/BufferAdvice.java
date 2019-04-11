package com.hj.aop05.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;
import java.util.*;

/**
 * Author: hj
 * Date: 2019-04-11 14:20
 * Description: 缓冲计算结果,使用环绕通知
 */
public class BufferAdvice implements MethodInterceptor {

    //k:封装的对象,v:缓存结果
    private Map<Key, Object> BufferMap = new HashMap<>();

    @Override

    public Object invoke(MethodInvocation invocation) throws Throwable {
        Method method = invocation.getMethod();
        Object[] args = invocation.getArguments();
        Object target = invocation.getThis();

        /*
         * 方法执行之前,先在缓冲中查找
         * */
        Key key = new Key();
        key.setMethod(method);
        key.setArgs(args);
        key.setTarget(target);
        //判断方法是否执行过,如果执行过,则直接返回结果
        if (BufferMap.containsKey(key)) {
            return BufferMap.get(key);
        }

        //如果没有执行过,则调用执行业务方法
        Object proceed = invocation.proceed();
        /*
         * 方法执行之前,将结果添加到缓存中
         * */
        BufferMap.put(key, proceed);

        return proceed;
    }
}
