package com.gfg;

public class Person {
    private String name;
    private int age;

    public Person() {
        System.out.println("Executing Person Constructor");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void walk(){
        System.out.println(name+" is walking");
    }

    private String getPrivateData(){
        return "PrivateData";
    }

    protected String getProtectedData(){
        return "ProtectedData";
    }

     String getDefaultData(){
        return "DefaultData";
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
