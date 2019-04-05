package com.hj.ioc01;

import lombok.Data;
import org.springframework.context.ApplicationContext;

/**
 * Author: hj
 * Date: 2019-04-04 20:30
 * Description: <描述>
 */
@Data
public class HelloSpring {

    private String name;

    public void show(){
        System.out.println("Hello:"+name);
    }
}
