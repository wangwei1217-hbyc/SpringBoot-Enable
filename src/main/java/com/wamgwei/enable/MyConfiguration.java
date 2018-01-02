package com.wamgwei.enable;

import org.springframework.context.annotation.Bean;

/**
 * Created by wangwei on 2018/1/2.
 */
public class MyConfiguration {

    @Bean
    public Runnable createRunnable(){
        return ()->{};
    }

    @Bean
    public Runnable createRunnable2(){
        return ()->{};
    }
}
