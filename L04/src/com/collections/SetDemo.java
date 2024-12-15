package com.collections;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {

    public static void main(String[] args) {
//        Set<Integer> set = new HashSet<>();
//        set.add(1);
//        set.add(10);
//        set.add(1);
//        set.add(10);
//        System.out.println(set.size());
//
        Set<Student> studentSet = new TreeSet<>();
        Student s1 = new Student("Rahul",1);
        Student s2 = new Student("Ravi",2);
        Student s3 = new Student("Rahul",1);
        Student s4 = new Student("Shashi",2);
        studentSet.add(s1);
        studentSet.add(s2);
        studentSet.add(s3);
        studentSet.add(s4);
        System.out.println(s1 == s3); // false
        System.out.println(s1.equals(s3));
        System.out.println(studentSet.size());

        System.out.println(studentSet);

    }
}
