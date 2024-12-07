package com.gfg;

public class InheritenceDemo {

    public static void main(String[] args) {

//        Person person = new Person();
//        person.setName("Rahul");
//        person.setAge(20);
//        person.walk();
//        System.out.println(person);

        Teacher teacher = new Teacher();
        teacher.setName("Shashi");
        teacher.setSubject("Java");
        teacher.setAge(23);
        teacher.teach();
        teacher.walk();
        System.out.println(teacher);
        teacher.walk();


        Person person = new Teacher();
        person.setName("Ravi");
        person.walk();

        Teacher teacher1 = (Teacher) person;
        teacher1.setSubject("Maths");
        person.walk();

//        Teacher teacher2 = new Person();
//        Teacher teacher2 = (Teacher) new Person();
//        teacher2.setSubject("English");
//        teacher2.walk();

    }
}
