package com.netply.glc.web.rest.pojo;

public class GymnastAdditional {
    private String middleName;
    private String preferredName;
    private String category;
    private String sagfNumber;


    public GymnastAdditional() {
    }

    public GymnastAdditional(String middleName, String preferredName, String category, String sagfNumber) {
        this.middleName = middleName;
        this.preferredName = preferredName;
        this.category = category;
        this.sagfNumber = sagfNumber;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getPreferredName() {
        return preferredName;
    }

    public String getCategory() {
        return category;
    }

    public String getSagfNumber() {
        return sagfNumber;
    }
}
