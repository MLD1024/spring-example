package com.lz.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


@Getter
@Setter
@ToString
public class User implements BeanNameAware , BeanClassLoaderAware, BeanFactoryAware, DisposableBean ,InitializingBean,SmartInitializingSingleton{
    private String name;
    private String info;
    private int age;


    public void setBeanName(String name)
    {
        System.out.println("回调 setBeanName");
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("回调 setBeanClassLoader");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("回调 setBeanFactory");
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("回调注解init方法");
    }

    @PreDestroy
    public void predestory(){
        System.out.println("回调注解销毁方法");
    }



    @Override
    public void destroy() throws Exception {
        System.out.println("回调 DisposableBean 销毁方法");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("回调 InitializingBean 初始化方法");
    }

    @Override
    public void afterSingletonsInstantiated() {
        System.out.println("SmartInitializingSingleton 初始化完成之后回调");
    }
}
