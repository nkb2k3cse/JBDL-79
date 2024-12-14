package com.exdemo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErrorDemo {

    public static void main(String[] args) {
        normalMethod();
    }

    //StackOverFlowError
    private static void normalMethod(){
        System.out.println("Normal Method");
        normalMethod();
    }

    //HeapOutOfMemoryError
    private static void heapOutOfMemoryDemo(){
        List<Date> dates = new ArrayList<>();
        while (true){
            Date date = new Date();
            dates.add(date);
        }
    }

}
