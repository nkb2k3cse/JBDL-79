package com.collections;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {

    public static void main(String[] args) {
        Map<String,Student> map = new HashMap();
        Student s1 = new Student("Rahul",1);
        Student s2 = new Student("Ravi",2);
        Student s3 = new Student("Rahul",1);
        Student s4 = new Student("Shashi",2);

        map.put("Rahul",s1);
        map.put("Ravi",s2);
        map.put(null,s3);
        map.put("shashi",null);
        System.out.println(map.size());
        System.out.println(map.get("Ravi"));
        System.out.println(map.get(null));
        System.out.println(map.get("shashi"));
        System.out.println(map.get("vishnu"));

        if(!map.keySet().contains("vis")){
        //if(map.get("shashi") == null){
            System.out.println("Does not exist");
        }
        else{
            System.out.println("exist");
        }
    }
}
