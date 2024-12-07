package com.gfg;

public class EncapsulationDemo {

    public static void main(String[] args) {

        Student student = new Student("Ravi",1, "234/24 Noida");
//        student.name = "Ravi";
//        student.address = "";

        System.out.println(student.getName());

//        student.phone = "";
        student.setPhone("9876567890");

        System.out.println(student.getPhone());

//        LectureTest lectureTest = new LectureTest();
        Lecture lecture = new Lecture();
        lecture.status = "live";
    }
}
