package com.netply.glc.web.rest.gymnast;

import com.netply.glc.web.rest.pojo.BasicGymnast;
import com.netply.glc.web.rest.pojo.GymnastAdditional;

import java.util.List;

public interface GymnastDatabase {
    void addGymnast(String firstName, String surname, String identificationNumber, String dateOfBirth);

    void editGymnast(int id, String firstName, String surname, String identificationNumber, String dateOfBirth);

    BasicGymnast getGymnast(int id);

    List<BasicGymnast> getGymnasts();

    GymnastAdditional getGymnastAdditional(int id);

    void editGymnastAdditional(int id, String middleName, String preferredName, String category);

    void deleteGymnast(int id);
}
