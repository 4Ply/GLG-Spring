package com.netply.glc.web.rest.medical;

import com.netply.glc.web.rest.pojo.MedicalInformation;

public interface MedicalDatabase {
    void editMedical(int gymnastId, MedicalInformation medicalInformation);

    MedicalInformation getMedical(int gymnastId);
}
