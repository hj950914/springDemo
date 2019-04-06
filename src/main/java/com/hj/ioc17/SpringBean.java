package com.hj.ioc17;

import lombok.Data;

/**
 * Author: hj
 * Date: 2019-04-06 16:50
 * Description: <描述>
 */
@Data
public class SpringBean {

    private OtherBean otherBean;

    public SpringBean(OtherBean otherBean) {
        this.otherBean = otherBean;
    }
}
