package com.wamgwei.enable;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;

/**
 * 接口ImportBeanDefinitionRegistrar其实跟接口ImportSelector作用类似。
 * 1，接口ImportBeanDefinitionRegistrar：Spring允许我们自由的往Spring容器当中注入Bean
 * 2，接口ImportSelector：我们提供一个元素为类的全路径名的数据，由Spring帮助我们完成对象的装配注入
 */
@Component
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar{
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        BeanDefinitionBuilder bdb = BeanDefinitionBuilder.rootBeanDefinition(Runtime.class);
        registry.registerBeanDefinition("runtime",bdb.getBeanDefinition());
    }
}
