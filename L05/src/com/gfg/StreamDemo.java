package com.gfg;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class StreamDemo {

    public static void main(String[] args) {

        List<Integer> integerList = Arrays.asList(2,4,5,7,8,10);
        Consumer<Integer> printInt = (a) -> {
            System.out.println(a);
            System.out.println(Thread.currentThread().getName());
        };
        Predicate<Integer> checkEven = (x) -> x%2 ==0;
        Function<Integer,Integer> sqFunc = (x) -> x*x;
        List<Integer> evenIntSq = integerList.stream()
                .filter(checkEven)
                .map(sqFunc)
                .toList();
        System.out.println(evenIntSq);
        integerList.stream().forEach(printInt);
        System.out.println("====");
        integerList.parallelStream().forEach(printInt);
    }
}
