package com.netply.glc.web.rest.medical;

import com.netply.glc.web.rest.pojo.MedicalInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MedicalManagerImpl implements MedicalManager {
    private MedicalDatabase medicalDatabase;


    @Autowired
    public MedicalManagerImpl(MedicalDatabase medicalDatabase) {
        this.medicalDatabase = medicalDatabase;
    }

    @Override
    public void editMedical(int gymnastId, MedicalInformation medicalInformation) {
        medicalDatabase.editMedical(gymnastId, medicalInformation);
    }

    @Override
    public MedicalInformation getMedical(int gymnastId) {
        return medicalDatabase.getMedical(gymnastId);
    }
}
