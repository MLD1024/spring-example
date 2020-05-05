package com.lz;

import com.lz.beanpostprocessor.CustomBeanPostProcessor;
import com.lz.beanpostprocessor.CustomInstantiationAwareBeanPostProcessor;
import com.lz.beanpostprocessor.CustomSmartInitializingSingleton;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnnotationConfig {

    @Bean
    public CustomBeanPostProcessor createCustomBeanPostProcessor(){
       return new CustomBeanPostProcessor();
    }

    @Bean
    public CustomInstantiationAwareBeanPostProcessor createCustomInstantiationAwareBeanPostProcessor(){
        return new CustomInstantiationAwareBeanPostProcessor();
    }
    @Bean
     public  CustomSmartInitializingSingleton createCustomSmartInitializingSingleton(){
        return new CustomSmartInitializingSingleton();
     }
}
