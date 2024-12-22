package com.multithreding;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceDemo {


    public static void main(String[] args) {

        //ExecutorService executorServiceSingleWorker = Executors.newSingleThreadExecutor();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        long start = System.currentTimeMillis();
        for(int i=0; i<100; i++){
            executorService.submit(() -> {
                System.out.println(" Task Running in : " + Thread.currentThread().getName());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });

        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long end = System.currentTimeMillis();
        System.out.println("Total Time:"+(end-start)+" ms Thread:"+Thread.currentThread().getName());
    }

//    public static void main(String[] args) {
//
////
////        ExecutorService fixExecutorService = Executors.newSingleThreadExecutor(); //Executors.newFixedThreadPool(5);
////        MyTask myTask = new MyTask();
////        fixExecutorService.submit(myTask);
////        fixExecutorService.submit(myTask);
////        fixExecutorService.submit(myTask);
////        fixExecutorService.submit(myTask);
////        fixExecutorService.submit(myTask);
////        fixExecutorService.submit(() -> {
////            System.out.println("lamda Task Running in : " + Thread.currentThread().getName());
////        });
////
////        fixExecutorService.shutdown();
//
//    }
}

/*
10K
 */
