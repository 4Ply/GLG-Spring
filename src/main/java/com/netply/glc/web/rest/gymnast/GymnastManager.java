package com.netply.glc.web.rest.gymnast;

import com.netply.glc.web.rest.error.NoSuchGymnastException;
import com.netply.glc.web.rest.pojo.BasicGymnast;
import com.netply.glc.web.rest.pojo.GymnastAdditional;

import java.util.List;

public interface GymnastManager {
    void addGymnast(String firstName, String surname, String identificationNumber, String dateOfBirth, String gender);

    void editGymnast(int id, String firstName, String surname, String identificationNumber, String dateOfBirth, String gender);

    BasicGymnast getGymnast(int id) throws NoSuchGymnastException;

    List<BasicGymnast> getGymnasts();

    void editGymnastAdditional(int id, String middleName, String preferredName, String category, String sagfNumber);

    GymnastAdditional getGymnastAdditional(int id);

    void deleteGymnast(int id);
}
