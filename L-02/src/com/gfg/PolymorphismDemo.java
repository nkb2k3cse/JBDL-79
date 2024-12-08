package com.gfg;

import java.util.Scanner;

public class PolymorphismDemo {

    public static void main(String[] args) {

        AreaCalculator areaCalculator = new AreaCalculator();
        System.out.println(areaCalculator.area(10));
        System.out.println(areaCalculator.area(10,12));


        OS os = null;
        System.out.println("Enter OS:");
        Scanner scanner = new Scanner(System.in);
        String osName = scanner.nextLine();
        if(osName.equals("ubuntu")){
            os = new Ubuntu();
        }
        else{
            os = new Windows();
        }
        os.manageCPU();
        System.out.println(os);

    }
}
