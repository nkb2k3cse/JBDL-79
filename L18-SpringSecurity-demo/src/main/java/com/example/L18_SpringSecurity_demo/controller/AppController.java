package com.example.L18_SpringSecurity_demo.controller;


import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class AppController {


//    @GetMapping("/hello")
//    public String getHello(){
//        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        return "Hello "+userDetails.getUsername()+" !! from "+Thread.currentThread().getName();
//    }


    @GetMapping("/hello")
    public String getHello(@AuthenticationPrincipal UserDetails userDetails){
        return "Hello "+userDetails.getUsername()+" !! from "+Thread.currentThread().getName();
    }



}
//JSESSIONID=F788F2F1FD889B41554F3EF1A212331A
//JSESSIONID=F788F2F1FD889B41554F3EF1A212331A