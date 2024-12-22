package com.multithreding.mmtDemo;

import java.util.ArrayList;
import java.util.List;

public class AirIndiaFlightSearchService implements FlightSearchInterface{

    @Override
    public List<FlightData> getFlightsBySrcDes(String src, String des) {
        // API call to airIndia Server
        //
        System.out.println("AirIndia in "+Thread.currentThread().getName());
        List<FlightData> data = new ArrayList<>();
        data.add(new FlightData("DLI", "BLR", 10000.00));
        data.add(new FlightData("DLI", "BLR", 11000.00));
        data.add(new FlightData("DLI", "BLR", 9000.00));
        return data;
    }
}
