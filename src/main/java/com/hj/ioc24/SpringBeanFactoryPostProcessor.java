package com.hj.ioc24;

import com.hj.ioc24.Editor.AddressEditor;
import com.hj.ioc24.Editor.DataEditor;
import lombok.Data;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import java.beans.PropertyEditor;
import java.util.Date;
import java.util.Map;


/**
 * Author: hj
 * Date: 2019-04-09 15:44
 * Description: <容器后处理器,数据装配之前执行>
 */

@Data
public class SpringBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    private Map<Class, Class> customEditors;

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("SpringBeanFactoryPostProcessor");

        /*
         * 一个一个的注册属性编辑器
         * */

        //注册Address类属性编辑器,第一个参数表示要转换的属性类型,第二个参数表示要使用的属性编辑器
        //beanFactory.registerCustomEditor(Address.class, AddressEditor.class);
        //注册Data属性编辑器
        //beanFactory.registerCustomEditor(Date.class, DataEditor.class);



        /*
         *   通过循环注册属性编辑器,将参数注入ioc容器。
         * */

        for (Map.Entry<Class, Class> entry : customEditors.entrySet()) {
            beanFactory.registerCustomEditor(entry.getKey(), entry.getValue());
        }
    }
}

