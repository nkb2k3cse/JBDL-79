package com.gfg;

public class Teacher extends Person{

    private String subject;

    public String getSubject() {
        return subject;
    }

    public Teacher() {
        System.out.println("Executing Teacher Constructor");
    }


    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void teach(){
        System.out.println(getName()+" is teaching "+subject);
    }

    @Override
    public void walk(){
        System.out.println(subject+" Teacher ");
        super.walk();
    }

    public void getSomeData(){
//        super.getPrivateData();
        getProtectedData();
        getDefaultData();
    }

    @Override
    public String toString() {
        String data = super.toString()+"Teacher{" +
                "subject='" + subject + '\'' +
                '}';
        return data;
    }

}
