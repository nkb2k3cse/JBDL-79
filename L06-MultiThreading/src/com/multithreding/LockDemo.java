package com.multithreding;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {

    public static void main(String[] args) {

        ReentrantLock reentrantLock = new ReentrantLock();

        ExecutorService executorService = Executors.newFixedThreadPool(1);

        executorService.submit(()->{
            reentrantLock.lock();
            System.out.println("Acquired lock");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            reentrantLock.unlock();
            System.out.println("Released lock");
        });


        while (reentrantLock.isLocked()){
            System.out.println("Not available");
        }
        //executorService.shutdownNow();
        System.out.println("Done");
    }
}
