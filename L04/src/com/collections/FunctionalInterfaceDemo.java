package com.collections;

public class FunctionalInterfaceDemo {


    public static void main(String[] args) {

        Fastag paytmFastag = new Fastag() {
            @Override
            public String getFastagDetials(String v) {
                System.out.println("Processing in Paytm "+v);
                return "Paytm Fastag Details";
            }
        };

        Fastag hdfcFastag = (vDetails) ->  {
            System.out.println("Processing in HDFC "+vDetails);
            return "HDFC Details";};

        System.out.println(paytmFastag.getFastagDetials("Tiago"));

        System.out.println(hdfcFastag.getFastagDetials("Punch"));


    }
}
