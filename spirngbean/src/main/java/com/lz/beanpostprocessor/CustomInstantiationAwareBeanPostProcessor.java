package com.lz.beanpostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

import java.util.Arrays;

public class CustomInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {



    // 实例化之前
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {

        System.out.println("实例化之前: "+beanName);
        return null;
    }


    // 实例化之后
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        System.out.println("实例化之后："+beanName);
        return true;
    }



    // 属性赋值之前
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        System.out.println("属性赋值之前: "+beanName+"值为："+bean+"pvs："+ Arrays.toString(pvs.getPropertyValues()));
        return null;
    }
}
