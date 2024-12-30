package com.gfg;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIoCDemo {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("projectbeans.xml");
        Engine engine1 = applicationContext.getBean("engine1", Engine.class);
        System.out.println(engine1);
        Engine engine1A = applicationContext.getBean("engine1", Engine.class);
        System.out.println(engine1A);
        System.out.println(engine1 == engine1A);// true


        Engine engine2 = applicationContext.getBean("engine2", Engine.class);
        System.out.println(engine2);
        Engine engine2A = applicationContext.getBean("engine2", Engine.class);
        System.out.println(engine2A);
        System.out.println("engine2 == engine2A:"+(engine2 == engine2A)); // false

        Car car1 = applicationContext.getBean("car1", Car.class);
        System.out.println(car1);
        System.out.println(engine1 == car1.getEngine());

        Engine engine3 = applicationContext.getBean("engine3", Engine.class);
        System.out.println(engine3);
        applicationContext.close();
        System.out.println(engine3);
    }
}
