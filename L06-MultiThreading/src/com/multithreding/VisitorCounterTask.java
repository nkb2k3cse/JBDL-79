package com.multithreding;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class VisitorCounterTask implements Runnable{

    private int count;

    //private AtomicInteger count;

    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        increment();
    }

//    private synchronized void  increment(){
//        /*
//
//         */
//            count++;
//        /*
//
//         */
//    }

//    private void increment() {
//        count.incrementAndGet();
//    }

    private void increment() {
       lock.lock();
        count++;
        lock.unlock();
    }

    @Override
    public String toString() {
        return "VisitorCounterTask{" +
                "count=" + count +
                '}';
    }
}
