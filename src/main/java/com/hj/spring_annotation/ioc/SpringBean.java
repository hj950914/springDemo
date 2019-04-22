package com.hj.spring_annotation.ioc;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Author: hj
 * Date: 2019-04-22 11:13
 * Description: <注解配置>
 */
@Component
@Data
@Lazy//设置成懒实例化
@Scope("prototype")//设置成非单例
public class SpringBean {
    /*
     * 基本类型装配
     * */
    @Value("111")
    private int num;

    @Value("true")
    private Boolean flag;

    @Value("${username}")
    private String username;

    @Value("java.lang.String")
    private Class aClass;

    @Value("classpath:spring_annotation/ioc/spring.xml")
    private Resource resource;

    /*
     * 方式1:使用@Autowired,Spring提供
     *       自动装配,默认按byType,如果有多个同类型的bean,则按byName
     * 方式2:@Resource,JavaEE提供
     * */
    @Autowired
    private OtherBean otherBean;

    /*
     * 集合装配,使用@Resource,按byName注入
     * */
    @javax.annotation.Resource
    private Integer[] arrays;

    @javax.annotation.Resource
    private List<OtherBean> list;

    @javax.annotation.Resource
    private Set<OtherBean> set;

    @javax.annotation.Resource
    private Map<OtherBean, Class> map;

    @javax.annotation.Resource
    private Properties properties;

    public SpringBean() {
        System.out.println("springBean.springBean");
    }

    //相当于init-method=""
    @PostConstruct
    public void init() {
        System.out.println("springBean.init");
    }

    //相当于destroy-method=""
    @PreDestroy
    public void destroy() {
        System.out.println("springBean.destroy");
    }
}
