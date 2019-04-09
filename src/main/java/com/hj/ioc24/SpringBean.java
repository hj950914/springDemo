package com.hj.ioc24;

import lombok.Data;

import java.util.List;
import java.util.Date;

/**
 * Author: hj
 * Date: 2019-04-09 15:18
 * Description: <描述>
 */
@Data
public class SpringBean {


    private List<Address> addressList;//地址

    private Date birthday;//出生日期

    private String username;//用户名

    private boolean sex;//性别,true(男)


}
