package com.hj.ioc24.Editor;


import com.hj.ioc24.Address;

import java.beans.PropertyEditorSupport;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Author: hj
 * Date: 2019-04-09 15:57
 * Description:  Address属性转换器
 */
public class AddressEditor extends PropertyEditorSupport {

    @Override
    public String getAsText() {
        return super.getAsText();
    }


    //将String字符串装换为对象
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Pattern pattern = Pattern.compile("\\[(.*)-(.*)\\]");
        Matcher matcher = pattern.matcher(text);
        Address address = new Address();
        if (matcher.matches()) {
            address.setCity(matcher.group(1));
            address.setProvince(matcher.group(2));
            //把封装的对象交给容器
            setValue(address);
        }
    }
}
