package com.generics;

public class TollProcessor <T extends MotorVehicle> {

    private T vehicle;

    void processToll(){
        /*

         */
    }


    public static void main(String[] args) {

//        TollProcessor<Cycle> tollProcessor = new TollProcessor<Cycle>();

        TollProcessor<Car> tollProcessor = new TollProcessor<Car>();
    }
}
