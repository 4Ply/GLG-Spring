package com.netply.glc.web.rest.pojo;

public class MedicalInformation {
    private String medicalAidName;
    private String medicalAidNumber;
    private String physicalDisabilities;


    public MedicalInformation() {
    }

    public MedicalInformation(String medicalAidName, String medicalAidNumber, String physicalDisabilities) {
        this.medicalAidName = medicalAidName;
        this.medicalAidNumber = medicalAidNumber;
        this.physicalDisabilities = physicalDisabilities;
    }

    public String getMedicalAidName() {
        return medicalAidName;
    }

    public String getMedicalAidNumber() {
        return medicalAidNumber;
    }

    public String getPhysicalDisabilities() {
        return physicalDisabilities;
    }
}
