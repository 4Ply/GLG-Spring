package com.netply.glc.web.rest.pojo;

public class GymnastAdditional {
    private String middleName;
    private String preferredName;
    private String category;


    public GymnastAdditional() {
    }

    public GymnastAdditional(String middleName, String preferredName, String category) {
        this.middleName = middleName;
        this.preferredName = preferredName;
        this.category = category;
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
}
