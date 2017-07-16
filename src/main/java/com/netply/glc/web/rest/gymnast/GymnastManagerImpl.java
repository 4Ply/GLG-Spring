package com.netply.glc.web.rest.gymnast;

import com.netply.glc.web.rest.error.NoSuchGymnastException;
import com.netply.glc.web.rest.pojo.BasicGymnast;
import com.netply.glc.web.rest.pojo.GymnastAdditional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GymnastManagerImpl implements GymnastManager {
    private GymnastDatabase gymnastDatabase;


    @Autowired
    public GymnastManagerImpl(GymnastDatabase gymnastDatabase) {
        this.gymnastDatabase = gymnastDatabase;
    }

    @Override
    public void addGymnast(String firstName, String surname, String identificationNumber, String dateOfBirth) {
        gymnastDatabase.addGymnast(firstName, surname, identificationNumber, dateOfBirth);
    }

    @Override
    public void editGymnast(int id, String firstName, String surname, String identificationNumber, String dateOfBirth) {
        gymnastDatabase.editGymnast(id, firstName, surname, identificationNumber, dateOfBirth);
    }

    @Override
    public BasicGymnast getGymnast(int id) throws NoSuchGymnastException {
        BasicGymnast gymnast = gymnastDatabase.getGymnast(id);
        if (gymnast == null) {
            throw new NoSuchGymnastException();
        }
        return gymnast;
    }

    @Override
    public List<BasicGymnast> getGymnasts() {
        List<BasicGymnast> gymnasts = gymnastDatabase.getGymnasts();
        if (gymnasts == null) {
            gymnasts = new ArrayList<>();
        }
        return gymnasts;
    }

    @Override
    public void editGymnastAdditional(int id, String middleName, String preferredName, String category) {
        gymnastDatabase.editGymnastAdditional(id, middleName, preferredName, category);
    }

    @Override
    public GymnastAdditional getGymnastAdditional(int id) {
        return gymnastDatabase.getGymnastAdditional(id);
    }

    @Override
    public void deleteGymnast(int id) {
        gymnastDatabase.deleteGymnast(id);
    }
}
