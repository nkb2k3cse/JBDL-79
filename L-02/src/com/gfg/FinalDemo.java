package com.gfg;

public class FinalDemo {
    public static void main(String[] args) {
        final int num = 10;
        //num =11;

        final Laptop laptop = new Laptop();
        //laptop = new Laptop();

//        CoreBusinessLogic coreBusinessLogic = new ProxyBusinessLogic();
        CoreBusinessLogic coreBusinessLogic = new CoreBusinessLogic();
        coreBusinessLogic.businessLogic1();



    }
}
