package com.gfg;

public class InterfaceDemo {


    public static void main(String[] args) {
//        IndiaITDeptNorm indiaITDeptNorm = new IndiaITDeptNorm();

//        Mobile mobile = new Mobile();


        Laptop laptop1 = new Laptop();

        IndiaITDeptNorm indiaITDeptNorm = laptop1;
        indiaITDeptNorm.someNewMethod();

        IndGovtNorm indGovtNorm = laptop1;
        indGovtNorm.someNewMethod();

        IndGovtNorm.printGovtName();
//        Laptop.printGovtName();
//        Keyboard.dataCable;
    }
}
