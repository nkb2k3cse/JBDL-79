package com.multithreding.mmtDemo;

import java.util.ArrayList;
import java.util.List;

public class MmtDemo {
    public static void main(String[] args) {
        List<FlightSearchInterface> flightSearchImps = new ArrayList<>();
        flightSearchImps.add(new GoFlightSearchService());
        flightSearchImps.add(new IndigoFlightSearchService());
        flightSearchImps.add(new AirIndiaFlightSearchService());
        MmtSearchService mmtSearchService = new MmtSearchService(flightSearchImps);
        System.out.println(mmtSearchService.getAllFlightDataPart2("DLI","BLR"));



//        MmtSearchService mmtSearchService = new MmtSearchService();
//        System.out.println(mmtSearchService.getAllFlightsBySrcAndDes("DLI","BLR"));

    }
}
