package com.gfg;

public class Ubuntu implements OS {

    @Override
    public void manageCPU() {
        System.out.println("Ubuntu CPU Management");
    }

    @Override
    public void manageOutputDevices() {

    }

    @Override
    public void manageInputDevices() {

    }

    public void ubuntuSpecificMethod(){

    }

    @Override
    public String toString() {
        return "Ubuntu{}";
    }
}
