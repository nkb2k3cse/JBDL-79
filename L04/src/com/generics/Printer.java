package com.generics;

public class Printer<T> {

    private T val;

    public Printer(T val) {
        this.val = val;
    }

    public void print(){
        System.out.println(val);
    }
}
