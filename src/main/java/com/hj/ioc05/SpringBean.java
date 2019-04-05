package com.hj.ioc05;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Author: hj
 * Date: 2019-04-05 16:02
 * Description: <描述>
 */
@Data
public class SpringBean {

    //其它bean的引用
    private OtherBean otherBean;

    //集合类型的装配
    private Integer[] arrays;

    private List<OtherBean> list;

    private Set<OtherBean> set;

    private Map<OtherBean, Class> map;

    private Properties properties;

}
