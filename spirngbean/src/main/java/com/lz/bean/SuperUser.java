package com.lz.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.BeansException;
import org.springframework.context.*;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.StringValueResolver;


@Getter
@Setter
@ToString(callSuper=true)
public class SuperUser extends User implements EnvironmentAware, EmbeddedValueResolverAware, ResourceLoaderAware, ApplicationEventPublisherAware,MessageSourceAware,ApplicationContextAware {
    private String title;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("回调 setApplicationContext");
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        System.out.println("回调 setApplicationEventPublisher");
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        System.out.println("回调 setEmbeddedValueResolver");

    }

    @Override
    public void setEnvironment(Environment environment) {
        System.out.println("回调 setEnvironment");
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {
        System.out.println("回调 setMessageSource");
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        System.out.println("回调 setResourceLoader");
    }
}