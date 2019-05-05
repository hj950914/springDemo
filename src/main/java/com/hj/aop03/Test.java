package com.hj.aop03;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.InvocationHandler;

import java.util.Date;

/**
 * Author: hj
 * Date: 2019-04-10 15:48
 * Description: <描述>
 */
public class Test {

    @org.junit.jupiter.api.Test
    public void test() {
        HelloWord helloWord = (HelloWord) Enhancer.create(
                HelloWord.class,//目标类的类型
                (InvocationHandler) (proxy, method, args) -> {//交叉业务逻辑
                    System.out.println(method.getName() + " start time:" + new Date().getTime());
                    return method.invoke(new HelloWord());
                }
        );
        System.out.println("代理类的类型：" + helloWord.getClass());
        helloWord.print();
    }
}
