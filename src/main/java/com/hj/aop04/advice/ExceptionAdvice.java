package com.hj.aop04.advice;

import org.springframework.aop.ThrowsAdvice;

/**
 * Author: hj
 * Date: 2019-04-11 12:54
 * Description: 异常通知
 * 可以添加多个该方法,匹配不同的异常,执行不同的操作
 */
public class ExceptionAdvice implements ThrowsAdvice {

    public void afterThrowing(Exception ex) {
        System.out.println("ExceptionAdvice.afterThrowing：" + ex);
    }

    public void afterThrowing(ArithmeticException ex) {
        System.out.println(ex + "发送短信");
    }

    public void afterThrowing(NullPointerException ex) {
        System.out.println(ex + "发送邮件");
    }
}
