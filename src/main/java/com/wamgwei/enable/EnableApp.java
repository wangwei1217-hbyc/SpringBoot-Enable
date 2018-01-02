package com.wamgwei.enable;

import com.sun.prism.Texture;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * -- @EnableConfigurationProperties启用配置文件到实体属性自动映射，与@ConfigurationProperties(prefix = "enable")结合使用
 * -- @EnableAsync//启用异步,与@Async集合使用
 * --@@Import({EnableConfigurationPropertiesImportSelector.class})导入一个或多个类、或配置类到Spring容器.
 *     如果导入的是一个配置类，则配置类中定义的Bean也都会被Spring容器托管
 */
//@SpringBootApplication
//@EnableAutoConfiguration
@EnableConfigurationProperties
//@EnableAsync//启用异步
@ComponentScan
@Import({User.class,MyImportSelector.class,MyConfiguration.class,MyImportBeanDefinitionRegistrar.class})
@MyAnnotation(name = "wangwei",value = "huying")
public class EnableApp {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(EnableApp.class, args);
        System.out.println(context.getBeansOfType(TomcatInfo.class));
//        context.getBean(MyRunnable.class).run();
        System.out.println(context.getBeansOfType(User.class));
        System.out.println(context.getBeansOfType(Girl.class));
        System.out.println(context.getBeansOfType(Role.class));
        System.out.println(context.getBeansOfType(Runnable.class));
        System.out.println(context.getBean(Runtime.class));

        System.out.println("========End=============");
        context.close();
    }
}
