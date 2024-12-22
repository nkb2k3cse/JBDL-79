package com.multithreding;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo {


    public static void main(String[] args) {

        int  corePoolSize  =    5;
        int  maxPoolSize   =   10;
        long keepAliveTime = 5000;
        ExecutorService threadPoolExecutor =
                new ThreadPoolExecutor(
                        corePoolSize,
                        maxPoolSize,
                        keepAliveTime,
                        TimeUnit.MILLISECONDS,
                        new LinkedBlockingQueue<Runnable>(50)
                );

        long start = System.currentTimeMillis();
        for(int i=0; i<100; i++){
            threadPoolExecutor.submit(() -> {
                System.out.println(" Task Running in : " + Thread.currentThread().getName());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });

        }
        threadPoolExecutor.shutdown();
        try {
            threadPoolExecutor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long end = System.currentTimeMillis();
        System.out.println("Total Time:"+(end-start)+" ms Thread:"+Thread.currentThread().getName());

    }
}
