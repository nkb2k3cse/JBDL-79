package com.gfg;

public class ClassObjDemo {

    public static void main(String[] args) {

        Lecture l01 = new Lecture();
        l01.mentor = "Shashi";
        l01.title ="Basics";
        l01.status ="Live";
        l01.joinNow();
        System.out.println(l01.title);
        Lecture l03 = new Lecture("L03 Java", "Shashi", "Upcoming");
        l03.mentor = "Ravi";
        System.out.println(l01.mentor);
        System.out.println(l03.mentor);
        System.out.println(l03.objNumbers);
        System.out.println(l01.objNumbers);
//        l01.objNumbers = 1;
//        System.out.println(l03.objNumbers);
//        System.out.println(l01.objNumbers);
        System.out.println("Done");
        testMethod();
        System.out.println(Lecture.objNumbers);
        //System.out.println(com.gfg.Lecture.status);

    }

    public static void testMethod(){
        int a =10;
        Lecture l02 = new Lecture("L02 Java", "Shashi", "Upcoming");
        System.out.println(a);
        l02.joinNow();
    }
}
