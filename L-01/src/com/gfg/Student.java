package com.gfg;

public class Student extends Person{

    private String name;
    private int rollNo;
    private String address;
    private String phone;

    public Student(String name, int rollNo, String address) {
        this.name = name;
        this.rollNo = rollNo;
        this.address = address;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setPhone(String phone) {
        /*
        data validation
         */
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }
}
