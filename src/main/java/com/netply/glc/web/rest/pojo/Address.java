package com.netply.glc.web.rest.pojo;

public class Address {
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String addressCode;
    private String school;


    public Address() {
    }

    public Address(String addressLine1, String addressLine2, String addressLine3, String addressCode, String school) {
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.addressLine3 = addressLine3;
        this.addressCode = addressCode;
        this.school = school;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public String getAddressLine3() {
        return addressLine3;
    }

    public String getAddressCode() {
        return addressCode;
    }

    public String getSchool() {
        return school;
    }
}
