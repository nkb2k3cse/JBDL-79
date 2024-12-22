package com.gfg;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class SupplierDemo {


    public static void main(String[] args) {
        Supplier<List<Person>> adminSupplier = () -> {
            /*

             */
            System.out.println("Starting...");
            List<Person> list = new ArrayList<>();
            list.add(new Person("Amit",43));
            list.add(new Person("Rakesh",33));
            return list;
        };
        System.out.println("Printing..");
        List<Person> people = adminSupplier.get();
        System.out.println(people);

    }
}
