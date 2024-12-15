package com.collections;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

public class ComparableComparatorDemo {

    public static void main(String[] args) {

        //PriorityQueue<Student> priorityQueue = new PriorityQueue<>();

//        PriorityQueue<Student> priorityQueue = new PriorityQueue<>(new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                return o1.getMarks() - o2.getMarks();
//            }
//        });

        PriorityQueue<Student> priorityQueue = new PriorityQueue<>((o1, o2) -> o1.getMarks() - o2.getMarks());

        Student s1 = new Student("Rahul",1,76);
        Student s2 = new Student("Ravi",2,65);
        Student s3 = new Student("Amit",5,67);
        Student s4 = new Student("Shashi",4,60);
        priorityQueue.add(s1);
        priorityQueue.add(s2);
        priorityQueue.add(s3);
        priorityQueue.add(s4);
        Student s = priorityQueue.poll();
        System.out.println(s);
    }
}
