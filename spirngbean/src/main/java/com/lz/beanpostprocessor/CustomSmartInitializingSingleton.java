package com.lz.beanpostprocessor;

import org.springframework.beans.factory.SmartInitializingSingleton;

public class CustomSmartInitializingSingleton implements SmartInitializingSingleton {


    // 初始化完成
    @Override
    public void afterSingletonsInstantiated() {
        System.out.println("初始化完成:afterSingletonsInstantiated");
    }
}
