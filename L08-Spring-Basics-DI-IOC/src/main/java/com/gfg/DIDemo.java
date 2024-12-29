package com.gfg;

public class DIDemo {

    public static void main(String[] args) {
        Engine engine = new Engine("Power",1500);
        Car car1 = new Car("Altroz",engine); // Constructor based DI done by Developer
        System.out.println(car1);
        Car car2 = new Car();
        car2.setName("Nexon");
        car2.setEngine(engine); // Setter based DI
        System.out.println(car2);
    }
}
