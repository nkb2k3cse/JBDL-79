package com.generics;

import com.collections.Student;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GenericsDemo {

    public static void main(String[] args) {

        IntegerPrinter integerPrinter = new IntegerPrinter(23);
        integerPrinter.print();

        StringPrinter stringPrinter = new StringPrinter("Shashi");
        stringPrinter.print();

        Printer<Integer> printer1 = new Printer<>(43);
        printer1.print();


        Printer<String> printer2 = new Printer<>("Data");
        printer2.print();


        Printer<Student> printer3 = new Printer<>(new Student("Rahul",3));
        printer3.print();


        List<String> list = new ArrayList<>();
        list.add("Shashi");
       // list.add(new Student("aa",4));

        Box<Student,Integer> box = new Box<>(new Student("Rahul",3),56);
        Box<Integer,String> integerBox = new Box<>(23,"abc");


        NumberBox<Integer> numberBox = new NumberBox<>(67);
        NumberBox<Long> longNumberBox = new NumberBox<>(67l);



    }
}

class Box<T,E>{
    private T item1;
    private E item2;

    public Box(T item1, E item2) {
        this.item1 = item1;
        this.item2 = item2;
    }

    public E getItem2() {
        return item2;
    }

    public void setItem2(E item2) {
        this.item2 = item2;
    }

    public T getItem1() {
        return item1;
    }

    public void setItem1(T item) {
        this.item1 = item;
    }
}

class NumberBox<T extends Number & Comparable>{
    private T item;

    public NumberBox(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}
