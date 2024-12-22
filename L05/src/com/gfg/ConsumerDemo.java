package com.gfg;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ConsumerDemo {

    public static void main(String[] args) {

        Consumer<String> printStr = (x) ->{
            System.out.println(x);
            System.out.println(x.startsWith("A"));
        };
        Predicate<Integer> checkEven = (x) -> x%2 == 0;
        printStr.accept("Ravi");
        printStr.accept("Ajay");
        List<Integer> integerList = Arrays.asList(2,4,5,7,8,10);
        Consumer<Integer> printInt = (a) -> System.out.println(a);
        integerList.stream().filter(checkEven).forEach(printInt);
    }
}
