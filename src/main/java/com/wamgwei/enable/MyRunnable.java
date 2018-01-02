package com.wamgwei.enable;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Created by wangwei on 2018/1/2.
 */
@Component
public class MyRunnable {

    @Async
    public void run(){
        for (int i=0;i<10;i++){
            System.out.println("=== "+i);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
