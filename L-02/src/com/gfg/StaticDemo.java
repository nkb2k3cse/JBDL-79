package com.gfg;

public class StaticDemo {

    public static void main(String[] args) {
        A obj1 = new A("Obj1");
        A obj2 = new A("Obj2");

//        System.out.println(A.getNum());
//        System.out.println(obj1.getNum());
//        System.out.println(obj2.getNum());
//
//        //System.out.println(A.getName());
//        System.out.println(obj1.getName());
//        System.out.println(obj2.getName());


    }
}

class A{
    private static int num =0;

    private String name;

    public A(String name) {
        System.out.println("Calling Constructor");
        this.name = name;
        num++;
    }

    static {
        System.out.println("Executing static block");
    }

    public static int getNum() {
        return num;
    }

    public static void setNum(int num) {
        A.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
