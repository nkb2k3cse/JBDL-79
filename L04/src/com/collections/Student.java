package com.collections;

import java.util.Objects;

public class Student implements Comparable {

    private String Name;

    private Integer rollNo;

    private Integer marks;

    public Integer getMarks() {
        return marks;
    }

    public void setMarks(Integer marks) {
        this.marks = marks;
    }

    public Student(String name, Integer rollNo) {
        Name = name;
        this.rollNo = rollNo;
    }

    public Student(String name, Integer rollNo, Integer marks) {
        Name = name;
        this.rollNo = rollNo;
        this.marks = marks;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getRollNo() {
        return rollNo;
    }

    public void setRollNo(Integer rollNo) {
        this.rollNo = rollNo;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(Name, student.Name) && Objects.equals(rollNo, student.rollNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Name, rollNo);
    }

    @Override
    public int compareTo(Object o) {
        Student s2 = (Student) o;
        if(((Student) o).rollNo.equals(this.rollNo)){
            return this.getName().compareTo(((Student) o).Name);
        }
        return this.rollNo - ((Student)o).getRollNo();
    }

    @Override
    public String toString() {
        return "Student{" +
                "Name='" + Name + '\'' +
                ", rollNo=" + rollNo +
                ", marks=" + marks +
                '}';
    }
}
