package com.collections;

import java.util.*;

public class UtilsDemo {

    public static void main(String[] args) {
        Integer [] arr = {34,23,56,78};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));;

        List<Integer> list = Arrays.asList(arr);
        //list.add(-10);
        System.out.println(list);

        List<Integer> list2 = Arrays.asList(10,1,9,100);
        Collections.sort(list2);
        System.out.println(list2);

        List<Student> studentArrayList = new ArrayList<>();
        Student s4 = new Student("Shashi",3);
        Student s1 = new Student("Rahul",1);
        Student s2 = new Student("Ravi",2);
        Student s3 = new Student("Ajay",4);
        Student s5 = new Student("Vijay",4);

        studentArrayList.add(s1);
        studentArrayList.add(s2);
        studentArrayList.add(s3);
        studentArrayList.add(s4);
        studentArrayList.add(s5);
        System.out.println(studentArrayList);
        Collections.sort(studentArrayList);
        System.out.println(studentArrayList);

    }
}
