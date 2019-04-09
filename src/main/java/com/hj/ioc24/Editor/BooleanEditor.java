package com.hj.ioc24.Editor;

import com.hj.ioc24.util.PropertiesUtils;

import java.beans.PropertyEditorSupport;

/**
 * Author: hj
 * Date: 2019-04-09 19:27
 * Description: <描述>
 */
public class BooleanEditor extends PropertyEditorSupport {

    @Override
    public String getAsText() {
        return super.getAsText();
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        System.out.println("BooleanEditor-setAsText");
        //判断是否合法字符
        if (PropertiesUtils.matcher(text)) {
            String key = PropertiesUtils.getKey(text);
            PropertiesUtils.loadind(BooleanEditor.class.getClassLoader().getResourceAsStream("ioc24/info.properties"));
            String value = (String) PropertiesUtils.getValue(key);
            System.out.println(value);
            Boolean b = Boolean.parseBoolean(value);
            setValue(b);
        }
    }
}
