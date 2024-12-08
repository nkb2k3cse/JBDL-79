package com.gfg;

public class EnumDemo {

    public static void main(String[] args) {
//        Lecture lecture1 = new Lecture("L01","Live");
//        Lecture lecture2 = new Lecture("L02","Eating");

        Lecture lecture1 = new Lecture("L01",Status.ARCHIVED);
        Lecture lecture2 = new Lecture("L02",Status.LIVE);

        System.out.println(lecture1);
        System.out.println(lecture2);

        String day1 = "Mon";
        String day2 = "Monday";

        Day day = Day.MONDAY;
        System.out.println(day.getName());
        System.out.println(day.getNo());
    }
}


