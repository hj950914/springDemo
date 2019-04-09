package com.hj.ioc24.Editor;

import com.hj.ioc24.util.PropertiesUtils;

import java.beans.PropertyEditorSupport;

/**
 * Author: hj
 * Date: 2019-04-09 19:26
 * Description: <描述>
 */
public class StringEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        //是否为合法字符
        if (PropertiesUtils.matcher(text)) {
            //获取key值
            String key = PropertiesUtils.getKey(text);
            //读取属性文件
            PropertiesUtils.loadind(StringEditor.class.getClassLoader().getResourceAsStream("ioc24/info.properties"));
            //获取值
            String value = (String) PropertiesUtils.getValue(key);
            setValue(value);
        }
    }
}
