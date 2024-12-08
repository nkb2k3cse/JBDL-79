package com.gfg;

public interface IndiaITDeptNorm {

    public static void printGovtName(){
        System.out.println("IT Dept Indian Government");
    }

    public void indiaITDepSpecificFunction();

    public void someNewMethod();


    default void someDefaultMethod(){
        System.out.println("Interface");
    }
}
