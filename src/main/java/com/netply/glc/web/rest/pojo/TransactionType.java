package com.netply.glc.web.rest.pojo;

public class TransactionType {
    private String name;
    private int value;


    public TransactionType() {
    }

    public TransactionType(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }
}
