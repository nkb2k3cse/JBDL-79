package com.multithreding;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class VisitorDemo {


    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        VisitorCounterTask visitorCounterTask = new VisitorCounterTask();

        for(int i =0; i<1000; i++){
            executorService.submit(visitorCounterTask);
        }
        executorService.shutdown();
       // executorService.shutdownNow();
        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(visitorCounterTask);
    }
}
