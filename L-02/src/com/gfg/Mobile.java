package com.gfg;

public abstract class Mobile implements IndiaITDeptNorm, IndGovtNorm{

    private String sim;

    public String getSim() {
        return sim;
    }

    public void setSim(String sim) {
        this.sim = sim;
    }

    @Override
    public void indiaSpecificFunction() {

    }

    final public void manageSIM(){
        //
    }

    public abstract void somethingActionMobileProvide();


    @Override
    public void indiaITDepSpecificFunction() {

    }

    @Override
    public void someNewMethod() {

    }

    @Override
    public void someDefaultMethod() {
        IndiaITDeptNorm.super.someDefaultMethod();
    }

    @Override
    public String getDeviceLocation() {
        return IndGovtNorm.super.getDeviceLocation();
    }
}
