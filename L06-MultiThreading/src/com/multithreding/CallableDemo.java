package com.multithreding;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableDemo {

    public static void main(String[] args) {

        List<String> data =  new ArrayList<>();

        Callable<String> callable = () -> {
            System.out.println("Executing in "+Thread.currentThread().getName());
           // data.get(1);
            Thread.sleep(100);
            return "SomeData";
        };

        List<Callable<String>> callableList = new ArrayList<>();
        callableList.add(callable);
        callableList.add(callable);
        callableList.add(callable);
        callableList.add(callable);

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<String> stringFuture = executorService.submit(callable);
        try {
            List<Future<String>> futureList = executorService.invokeAll(callableList);
            futureList.forEach((f)->{
                try {
                    String output = f.get();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (ExecutionException e) {
                    throw new RuntimeException(e);
                }

            });
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        try {
            System.out.println(stringFuture.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        executorService.shutdown();
        System.out.println("Done");
    }
}
