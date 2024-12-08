package com.gfg;

public interface OS {

     public static void staticMethod(){
          System.out.println("Data");
     }

     void manageCPU();

     public void manageOutputDevices();

     void manageInputDevices();
}
