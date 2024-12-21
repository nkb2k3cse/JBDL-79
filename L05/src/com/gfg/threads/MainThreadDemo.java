package com.gfg.threads;

import com.gfg.Person;

import java.util.ArrayList;
import java.util.List;

public class MainThreadDemo {

    public static void main(String[] args) {
        System.out.println("Starting....");
        System.out.println("ThreadName:"+Thread.currentThread().getName());

        List<Person> list = new ArrayList<>();
        list.add(new Person(34));
        MyThread myThread = new MyThread(list);
        myThread.setName("test-thread-0");
        myThread.start(); // Worker Thread
//        myThread.run();
        try {
            myThread.join();
//            myThread.getList().forEach();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        MyTask myTask = new MyTask();
        Thread t1 = new Thread(myTask);
        t1.setName("worker-0");
        t1.start();


//        Runnable task = () -> {
//            System.out.println("Executing lamda code in "+Thread.currentThread().getName());
//        };
        //Thread t2 = new Thread(() -> System.out.println("Executing lamda code in "+Thread.currentThread().getName()));
        Thread t2 = new Thread(myTask);
        t2.setName("worker-2");
        t2.start();

        System.out.println("Terminating....");
    }
}
