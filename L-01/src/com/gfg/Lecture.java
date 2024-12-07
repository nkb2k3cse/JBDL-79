package com.gfg;

public class Lecture {

    String title;
    String mentor;
    String status;
    int dayOfWeek;
    public static Integer objNumbers = 0;



    public Lecture(String title, String mentor, String status) {
        this.title = title;
        this.mentor = mentor;
        this.status = status;
        objNumbers++;
    }

    public Lecture() {
        objNumbers++;
    }

    void joinNow(){
        System.out.println("Launch Zoom");
    }

    private class LectureTest {

    }
}


