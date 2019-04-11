package com.hj.aop04.advice;

import lombok.Data;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

/**
 * Author: hj
 * Date: 2019-04-11 12:31
 * Description: 环绕通知
 */
@Data
public class TimeAdvice implements MethodInterceptor {

    private long time;

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Method method = invocation.getMethod();//方法
        Object[] args = invocation.getArguments();//参数
        Object target = invocation.getThis();//目标对象

        //方法执行前
        long startTime = System.currentTimeMillis();
        System.out.println("方法执行前....");

        Object proceed = invocation.proceed();//执行业务逻辑,其实就是调用业务方法,返回值表示执行业务方法后返回的结果

        //方法执行后
        long endtime = System.currentTimeMillis();
        System.out.println("方法执行后....执行"+method.getName()+"花费"+(endtime-startTime)+"ms");

        if (endtime - startTime >time) {
            //发送短信通知
            System.out.println("警报!!!!!");
        }

        return proceed;
    }
}
