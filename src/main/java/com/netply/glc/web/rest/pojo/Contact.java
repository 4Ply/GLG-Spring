package com.netply.glc.web.rest.pojo;

public class Contact {
    private int id;
    private String firstName;
    private String surname;
    private String phoneNumber;
    private String alternativePhoneNumber;
    private String emailAddress;
    private String alternativeEmailAddress;


    public Contact() {
    }

    public Contact(int id, String firstName, String surname, String phoneNumber, String alternativePhoneNumber, String emailAddress, String alternativeEmailAddress) {
        this(firstName, surname, phoneNumber, alternativePhoneNumber, emailAddress, alternativeEmailAddress);
        this.id = id;
    }

    public Contact(String firstName, String surname, String phoneNumber, String alternativePhoneNumber, String emailAddress, String alternativeEmailAddress) {
        this.firstName = firstName;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.alternativePhoneNumber = alternativePhoneNumber;
        this.emailAddress = emailAddress;
        this.alternativeEmailAddress = alternativeEmailAddress;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAlternativePhoneNumber() {
        return alternativePhoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getAlternativeEmailAddress() {
        return alternativeEmailAddress;
    }
}
