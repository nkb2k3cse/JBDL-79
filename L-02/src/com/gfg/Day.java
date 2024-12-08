package com.gfg;

public enum Day {
    SUNDAY("SUN",1),MONDAY("MON",2);

    private String name;
    private Integer no;


    private Day(String name, Integer no) {
        this.name = name;
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public Integer getNo() {
        return no;
    }

}
