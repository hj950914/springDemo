package com.hj.spring_annotation.aop.service;

/**
 * Author: hj
 * Date: 2019-04-10 14:33
 * Description: <描述>
 */
public interface UserService {

    public void login(String username, String password);//登录

    public void logout();//注销
}
