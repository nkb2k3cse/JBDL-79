package com.exdemo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class ExceptionDemo {

    public static void main(String[] args) {
//        System.out.println("Line 1");
//        System.out.println("Line 2");
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter Your Name");
//        String name = scanner.nextLine();
//        if(name.length() >= 6){
//            System.out.println(name.charAt(5));
//        }
//        System.out.println("Line 3");
//        System.out.println("Done");
//

//        readFromFile();
//        System.out.println("Done");
//
//        try {
//            readFromFile2();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        OrderService orderService = new OrderService();
        try {
            orderService.placeOrder("1234");
        } catch (ProductNotFoundException e) {
            System.out.println(e.getProductId()+":"+e.getMessage());
        }

        System.out.println("Main Done");
    }

    private static void readFromFile() {
        try {
            FileReader fileReader1 = new FileReader("/tmp/test03.txt");
            int a = fileReader1.read();
            fileReader1.close();
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException");
            throw new RuntimeException("Custom Msg for FileNotFoundException",e);
        } catch (IOException e) {
            System.out.println("IOException");
        }
        finally {
            System.out.println("finally block");
        }
        System.out.println("readFromFile  Done");
    }


    private static void readFromFile2() throws IOException {

            FileReader fileReader1 = new FileReader("/tmp/test03.txt");
            int a = fileReader1.read();
            fileReader1.close();
        System.out.println("readFromFile2  Done");
    }

}
