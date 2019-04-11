package com.hj.aop05.service.impl;

import com.hj.aop05.service.CaluService;

/**
 * Author: hj
 * Date: 2019-04-11 14:11
 * Description: <描述>
 */
public class CaluServiceImpl implements CaluService {
    @Override
    public int add(int numberA, int numberB) {
        System.out.println("CaluServiceImpl.add");
        return numberA + numberB;
    }

    @Override
    public double sub(double numberA, double numberB) {
        System.out.println("CaluServiceImpl.sub");
        return numberA - numberB;
    }
}
