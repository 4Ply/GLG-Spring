package com.netply.glc.web.rest;

import com.netply.glc.web.rest.medical.MedicalManager;
import com.netply.glc.web.rest.pojo.Address;
import com.netply.glc.web.rest.pojo.MedicalInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MedicalController {
    private MedicalManager medicalManager;


    @Autowired
    public MedicalController(MedicalManager medicalManager) {
        this.medicalManager = medicalManager;
    }

    @RequestMapping(value = "/medical", consumes = "application/json", produces = "application/json", method = RequestMethod.POST)
    public void editMedical(
            @RequestParam(value = "gymnastId") Integer gymnastId,
            @RequestBody MedicalInformation medicalInformation) {
        medicalManager.editMedical(gymnastId, medicalInformation);
    }

    @RequestMapping(value = "/medical", produces = "application/json", method = RequestMethod.GET)
    @ResponseBody
    public MedicalInformation getMedical(
            @RequestParam(value = "gymnastId") Integer gymnastId) {
        return medicalManager.getMedical(gymnastId);
    }
}
