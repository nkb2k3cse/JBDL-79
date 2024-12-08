package com.gfg;

public class SingletonDemo {

    public static void main(String[] args) {

        Principal principal1 = Principal.getInstance();

        Principal principal2 = Principal.getInstance();

        System.out.println(Principal.getObjectCount());
        System.out.println(principal1.getName());
        System.out.println(principal2.getName());
        System.out.println(principal2.equals(principal1));
    }
}
