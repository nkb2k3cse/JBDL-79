package com.multithreding.mmtDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MmtSearchService {

    private ExecutorService executorService = Executors.newFixedThreadPool(10);

    List<FlightSearchInterface> flightSearchInterfaces;

    public MmtSearchService() {
    }

    public MmtSearchService(List<FlightSearchInterface> flightSearchInterfaces) {
        this.flightSearchInterfaces = flightSearchInterfaces;
    }

    public List<FlightData> getAllFlightDataPart2(String src, String des){
        List<FlightData> response = new ArrayList<>();

        List<Callable<List<FlightData>>> callableList = new ArrayList<>();

        for(FlightSearchInterface flightSearchImpl : flightSearchInterfaces){
            Callable<List<FlightData>> callable = () -> {
                System.out.println("Executing in "+Thread.currentThread().getName());
              return   flightSearchImpl.getFlightsBySrcDes(src,des);
            };
            callableList.add(callable);
        }

        try {
            List<Future<List<FlightData>>> futureList = executorService.invokeAll(callableList);
            for(Future<List<FlightData>> future : futureList){
                try {
                    response.addAll(future.get(300,TimeUnit.MILLISECONDS));
                } catch (TimeoutException e) {
                    throw new RuntimeException(e);
                } catch (ExecutionException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return response;
    }

    public List<FlightData> getAllFlightsBySrcAndDes(String src, String des){
        List<FlightData> response = new ArrayList<>();

        FlightSearchInterface indigoFlightSearchService = new IndigoFlightSearchService();
        FlightSearchInterface goFlightSearchService = new GoFlightSearchService();
        Callable<List<FlightData>> callableForIndigo = () -> {
            System.out.println("Calling indigo API in "+Thread.currentThread().getName());
            return indigoFlightSearchService.getFlightsBySrcDes(src,des);
        };
        Callable<List<FlightData>> callableForGoAir = () -> {
            System.out.println("Calling GoAir API in "+Thread.currentThread().getName());
            return goFlightSearchService.getFlightsBySrcDes(src,des);
        };
        Future<List<FlightData>> futureIndigoData = executorService.submit(callableForIndigo);
        Future<List<FlightData>> futureGoAirData = executorService.submit(callableForGoAir);
        try {
            List<FlightData> indigoData = futureIndigoData.get(100,TimeUnit.MILLISECONDS);
            List<FlightData> goData = futureGoAirData.get();
            response.addAll(indigoData);
            response.addAll(goData);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }
        return response;
    }
}

