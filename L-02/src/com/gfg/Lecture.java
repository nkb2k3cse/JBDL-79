package com.gfg;

public class Lecture {

    private String title;

    private Status status;

    public Lecture(String title, Status status) {
        this.title = title;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Lecture{" +
                "title='" + title + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

enum Status{
    UPCOMING("Upcoming"),LIVE("Live"),ARCHIVED("Archived");
    String value;

    Status(String value) {
        this.value = value;
    }
}
