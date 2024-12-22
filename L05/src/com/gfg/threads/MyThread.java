package com.gfg.threads;

import com.gfg.Person;

import java.util.List;

public class MyThread extends Thread {

    private List<Person> list;

    public MyThread(List<Person> list) {
        this.list = list;
    }

    @Override
    public void run(){
        System.out.println("MyThread running in:"+Thread.currentThread().getName());
        /*

         */
    }

    public List<Person> getList() {
        return list;
    }

    public void setList(List<Person> list) {
        this.list = list;
    }
}

