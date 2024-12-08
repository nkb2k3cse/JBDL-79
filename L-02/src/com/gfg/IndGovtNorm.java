package com.gfg;

public interface IndGovtNorm {

    public static void printGovtName(){
        System.out.println("Indian Government");
    }

    public void indiaSpecificFunction();

    public void someNewMethod();

    default String getDeviceLocation(){
        return "Does not support";
    }

    default void someDefaultMethod(){
        System.out.println("Interface");
    }
}
