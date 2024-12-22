package com.multithreding.mmtDemo;

import java.util.List;

public interface FlightSearchInterface {
    List<FlightData> getFlightsBySrcDes(String src, String des);
}
