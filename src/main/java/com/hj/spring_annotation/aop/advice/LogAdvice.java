package com.hj.spring_annotation.aop.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Author: hj
 * Date: 2019-04-22 14:02
 * Description: <描述>
 */
@Component
@Aspect //表示这是一个切面
public class LogAdvice {

    //定义切点表达式
    @Pointcut("execution(* com.hj.spring_annotation.aop.service.impl.*ServiceImpl.*(..))")
    public void pc() {
    }

    @Pointcut("execution(* com.hj.spring_annotation.aop.service.impl.*.*(..))")
    public void pc2() {
    }

    /*
     * 前置通知
     * */
    @Before("pc()")
    public void before(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName() + " " + Arrays.toString(joinPoint.getArgs()));
    }

    /*
     * 后置通知
     * */
    @AfterReturning(value = "pc()", returning = "returnValue")
    public void afterReturning(JoinPoint joinPoint, Object returnValue) {
        System.out.println("AfterReturning.afterReturning->" + returnValue);
    }

    /*
     * 异常通知
     * */
    //@AfterThrowing(value = "pc2()", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Exception e) {
        System.out.println(e);
    }

    /*
    * 环绕通知
    * */
    @Around("pc2()")
    public Object around(ProceedingJoinPoint joinPoint){
        System.out.println("开启事务...");

        Object proceed=null;
        try {
            proceed = joinPoint.proceed();
            System.out.println("提交事务....");
        } catch (Throwable throwable) {
            System.out.println("回滚事务");
            throwable.printStackTrace();
        }
        return proceed;
    }
}
