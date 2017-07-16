package com.netply.glc.web.rest;

import com.netply.glc.web.rest.error.NoSuchGymnastException;
import com.netply.glc.web.rest.gymnast.GymnastManager;
import com.netply.glc.web.rest.pojo.BasicGymnast;
import com.netply.glc.web.rest.pojo.GymnastAdditional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class GymnastController {
    private GymnastManager gymnastManager;


    @Autowired
    public GymnastController(GymnastManager gymnastManager) {
        this.gymnastManager = gymnastManager;
    }

    @RequestMapping(value = "/gymnast", consumes = "application/json", produces = "application/json", method = RequestMethod.PUT)
    public void addGymnast(
            @RequestParam(value = "firstName") String firstName,
            @RequestParam(value = "surname") String surname,
            @RequestParam(value = "identificationNumber") String identificationNumber,
            @RequestParam(value = "dateOfBirth") String dateOfBirth) {
        gymnastManager.addGymnast(firstName, surname, identificationNumber, dateOfBirth);
    }

    @RequestMapping(value = "/gymnast", consumes = "application/json", produces = "application/json", method = RequestMethod.POST)
    public void editGymnast(
            @RequestParam(value = "id") Integer id,
            @RequestBody BasicGymnast gymnast) {
        gymnastManager.editGymnast(id, gymnast.getFirstName(), gymnast.getSurname(), gymnast.getIdentificationNumber(), gymnast.getDateOfBirth());
    }

    @RequestMapping(value = "/gymnast", produces = "application/json", method = RequestMethod.GET)
    @ResponseBody
    public BasicGymnast getGymnast(
            @RequestParam(value = "id") Integer id) throws NoSuchGymnastException {
        return gymnastManager.getGymnast(id);
    }

    @RequestMapping(value = "/gymnasts", produces = "application/json", method = RequestMethod.GET)
    @ResponseBody
    public List<BasicGymnast> getGymnasts() {
        return gymnastManager.getGymnasts().stream().distinct().collect(Collectors.toList());
    }

    @RequestMapping(value = "/gymnast_additional", consumes = "application/json", produces = "application/json", method = RequestMethod.POST)
    public void editGymnastAdditional(
            @RequestParam(value = "id") Integer id,
            @RequestBody GymnastAdditional gymnastAdditional) {
        gymnastManager.editGymnastAdditional(id, gymnastAdditional.getMiddleName(), gymnastAdditional.getPreferredName(), gymnastAdditional.getCategory());
    }

    @RequestMapping(value = "/gymnast_additional", produces = "application/json", method = RequestMethod.GET)
    @ResponseBody
    public GymnastAdditional getGymnastAdditional(
            @RequestParam(value = "id") Integer id) {
        return gymnastManager.getGymnastAdditional(id);
    }

    @RequestMapping(value = "/gymnast", consumes = "application/json", produces = "application/json", method = RequestMethod.DELETE)
    public void deleteGymnast(
            @RequestParam(value = "id") Integer id) {
        gymnastManager.deleteGymnast(id);
    }
}
