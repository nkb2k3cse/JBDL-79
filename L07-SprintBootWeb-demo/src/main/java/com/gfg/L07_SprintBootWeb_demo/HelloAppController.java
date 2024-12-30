package com.gfg.L07_SprintBootWeb_demo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloAppController {
    @GetMapping("/hello")
    public String getHello(){
        System.out.println("Processing Request hello");
        return "Hello from :"+Thread.currentThread().getName();
    }


    @GetMapping("/person")
    public Person getPerson(){
        System.out.println("Processing Request person");
        return new Person("Ravi",26);
    }
}
