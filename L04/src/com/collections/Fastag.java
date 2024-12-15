package com.collections;

@FunctionalInterface
public interface Fastag {

    String getFastagDetials(String vehicleNo);

    default String anotherMethod(){
        System.out.println();
        return "";
    }
}
