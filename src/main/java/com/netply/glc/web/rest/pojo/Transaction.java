package com.netply.glc.web.rest.pojo;

public class Transaction {
    private int id;
    private int gymnastId;
    private String date;
    private double amount;
    private String type;
    private String method;
    private String notes;


    public Transaction() {
    }

    public Transaction(int id, int gymnastId, String date, double amount, String type, String method, String notes) {
        this(gymnastId, date, amount, type, method, notes);
        this.id = id;
    }

    public Transaction(int gymnastId, String date, double amount, String type, String method, String notes) {
        this.gymnastId = gymnastId;
        this.date = date;
        this.amount = amount;
        this.type = type;
        this.method = method;
        this.notes = notes;
    }

    public int getId() {
        return id;
    }

    public int getGymnastId() {
        return gymnastId;
    }

    public String getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    public String getMethod() {
        return method;
    }

    public String getNotes() {
        return notes;
    }
}
