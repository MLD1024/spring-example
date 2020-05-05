package com.lz;

import com.lz.bean.SuperUser;
import com.lz.bean.User;
import com.lz.beanpostprocessor.CustomBeanPostProcessor;
import com.lz.beanpostprocessor.CustomInstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
   private static String FILEPATH = "spring-bean.xml";
   private static String FILEPATH2 = "spring-config.xml";
    public static void main(String[] args) {
//        createXmlApplication();
//        createXmlBeanFactory();
//        createAnnotatedBeanFactory();
//        createMergeBeanDefinition();
//        createInstaantiationAwareBeanPostProcessor();
//          createAwareBean();
//          createApplicationAwareBean();
//        createBeanLife();
        createApplicationBeanLife();
    }

    private static void createApplicationBeanLife() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(FILEPATH);
        applicationContext.setConfigLocation(FILEPATH2);
        User user = applicationContext.getBean(User.class);
        System.out.println(user);
    }


    private static void createBeanLife() {
        // 创建bean 容器对象
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 添加 beanPostProcessor
        // bean 创建销毁 注解解析
        beanFactory.addBeanPostProcessor(new CommonAnnotationBeanPostProcessor());
        // bean 实例化之
        beanFactory.addBeanPostProcessor(new CustomInstantiationAwareBeanPostProcessor());
        // bean 初始化
        beanFactory.addBeanPostProcessor(new CustomBeanPostProcessor());




        // 创建 xml 解析器
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        // 添加资源
        beanDefinitionReader.loadBeanDefinitions(FILEPATH);

        // 获取bean
        User bean = beanFactory.getBean(User.class);
        System.out.println(bean);

        beanFactory.destroySingletons();

    }

    private static void createApplicationAwareBean() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext();
        applicationContext.setConfigLocation(FILEPATH);
        applicationContext.refresh();
        User bean = applicationContext.getBean(User.class);
        System.out.println(bean);
    }

    private static void createAwareBean() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        beanDefinitionReader.loadBeanDefinitions(FILEPATH);
        User user = beanFactory.getBean(SuperUser.class);
        System.out.println(user);
    }
    private static void createInstaantiationAwareBeanPostProcessor() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        beanDefinitionReader.loadBeanDefinitions(FILEPATH);
        beanFactory.addBeanPostProcessor(new CustomInstantiationAwareBeanPostProcessor());
    }



    private static void createMergeBeanDefinition() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        beanDefinitionReader.loadBeanDefinitions(FILEPATH);

        SuperUser bean = beanFactory.getBean(SuperUser.class);
        System.out.println(bean);
    }


    private static void createAnnotatedBeanFactory() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        AnnotatedBeanDefinitionReader annotatedBeanDefinitionReader = new AnnotatedBeanDefinitionReader(beanFactory);
        annotatedBeanDefinitionReader.registerBean(User.class);
        System.out.println(beanFactory.getBean(User.class));
    }

    private static void createXmlBeanFactory() {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        xmlBeanDefinitionReader.loadBeanDefinitions(FILEPATH);
        System.out.println(beanFactory.getBean(User.class));
    }

    private static void createXmlApplication(){

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(FILEPATH);

        User user = applicationContext.getBean("user", User.class);

        System.out.println(user);

    }

}
