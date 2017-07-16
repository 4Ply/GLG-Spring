package com.netply.glc.web.rest.pojo;

public class Event {
    private int id;
    private String date;
    private String type;


    public Event() {
    }

    public Event(String date, String type) {
        this.date = date;
        this.type = type;
    }

    public Event(int id, String date, String type) {
        this(date, type);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getType() {
        return type;
    }
}
