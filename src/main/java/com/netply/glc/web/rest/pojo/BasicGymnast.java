package com.netply.glc.web.rest.pojo;

public class BasicGymnast {
    private int id;
    private String firstName;
    private String surname;
    private String identificationNumber;
    private String dateOfBirth;


    public BasicGymnast() {
    }

    public BasicGymnast(int id, String firstName, String surname, String identificationNumber, String dateOfBirth) {
        this.id = id;
        this.firstName = firstName;
        this.surname = surname;
        this.identificationNumber = identificationNumber;
        this.dateOfBirth = dateOfBirth;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }
}
