package com.hj.aop06.advice;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

/**
 * Author: hj
 * Date: 2019-04-11 16:07
 * Description:  增强类
 */
public class LodAdvice {

    //前置增强
    public void log(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();//签名
        String methodName = signature.getName();//方法名
        MethodSignature methodSignature = (MethodSignature) signature;//转换为方法签名,本质上是方法签名
        Method method = methodSignature.getMethod();
        Object[] args = joinPoint.getArgs();//方法参数
        Object target = joinPoint.getTarget();//目标对象

        System.out.println("LodAdvice.log,methodName:" + methodName);
    }

    //后置增强
    public void log2(JoinPoint joinPoint, Object returnValue) {
        System.out.println("LodAdvice.log2，returnValue ->" + returnValue);
    }

    //异常通知
    public void log3(JoinPoint joinPoint, Exception e) {
        System.out.println("LodAdvice.log3,:" + e);
    }

    //环绕通知
    public Object log4(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        System.out.println("方法执行前....");

        Object proceed = joinPoint.proceed();

        long endTime = System.currentTimeMillis();
        System.out.println("方法执行后....执行" + joinPoint.getSignature().getName() +
                "花费" + (endTime - startTime) + "ms");

        return proceed;
    }
}
