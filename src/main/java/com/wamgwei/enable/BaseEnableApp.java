package com.wamgwei.enable;

import com.wangwei.base.spring.Person;
import com.wangwei.base.spring.Tree;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 *  --@EnableAutoConfiguration的作用:从classpath搜索META-INF/spring.factories配置文件，
 *  将其中以org.springframework.boot.autoconfigure.EnableAutoConfiguration为key所对应的所有class类添加到Spring容器
 *
 *  只有在spring.boot.enableautoconfiguration=true时，自动配置才会启用
 *  --@EnableAutoConfiguration注解排除方式有两种：1，根据class来排除；2，根据className来排除
 *
 *  --@EnableAutoConfiguration内部实现关键点：
 *  ----1，ImportSelector  该接口的方法的返回值都会被装配到Spring容器中
 *  ----2，SpringFactoriesLoader类  该类可以从classpath下搜索META-INF/spring.factories配置文件，并读取其中的配置。
 */
//@EnableAutoConfiguration(exclude = {Tree.class})
//@EnableAutoConfiguration(excludeName = {"com.wangwei.base.spring.Tree"})
@EnableAutoConfiguration
@ComponentScan
public class BaseEnableApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BaseEnableApp.class, args);
        System.out.println(context.getBean(MyRunnable.class));
//        System.out.println(context.getBean(Runnable.class));
        System.out.println(context.getBean(Person.class));
        System.out.println(context.getBean(Tree.class));

        context.close();
    }
}
