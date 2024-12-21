package com.gfg;

import java.util.function.Function;

public class FunctionDemo {

    public static void main(String[] args) {
        Function<String,Person> nameToPerson = (name) -> new Person(name,23);
        Person p1 = nameToPerson.apply("Ajay");
        System.out.println(p1.getName());


    }
}
