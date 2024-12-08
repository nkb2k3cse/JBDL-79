package com.gfg;

public class Laptop implements IndGovtNorm, IndiaITDeptNorm {

    private OS os;

    private Keyboard keyboard;

    //Loose Coupling
    public Laptop(OS os, Keyboard keyboard) {
        this.os = os;
        this.keyboard = keyboard;
    }

    public Laptop(Keyboard keyboard) {
        this.keyboard = keyboard;
        this.os = new Windows();
    }

    // tight coupling
    public Laptop() {
        os = new Ubuntu();
        keyboard = new DellKeyboard();
    }

    @Override
    public void indiaSpecificFunction() {

    }

    @Override
    public void someNewMethod() {
        System.out.println("Laptop method");
    }

    @Override
    public void indiaITDepSpecificFunction() {

    }

    @Override
    public String getDeviceLocation(){
        return  "lat: log:";
    }

    @Override
    public void someDefaultMethod() {
        System.out.println("Laptop");
    }
}
