package com.gfg;

public class Principal {

    private static int objectCount;

    private static Principal instance = new Principal("Ravi");

    private String name;

    private Principal(String name) {
        /*

         */
        this.name = name;
        objectCount++;
    }

    public static Principal getInstance(){
        return instance;
    }
    public void manageSchool(){

    }

    public void approveStaffLeaves(){

    }

    public static int getObjectCount() {
        return objectCount;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Principal{" +
                "name='" + name + '\'' +
                '}';
    }
}
