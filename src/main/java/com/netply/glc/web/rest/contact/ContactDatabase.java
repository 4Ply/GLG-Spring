package com.netply.glc.web.rest.contact;

import com.netply.glc.web.rest.pojo.Contact;

import java.util.List;

public interface ContactDatabase {
    void addContact(Contact contact);

    void editContact(int id, Contact contact);

    Contact getContact(int id);

    void addContactLink(int gymnastId, int contactId);

    void deleteContactLink(int gymnastId, int contactId);

    List<Contact> getContacts();

    List<Contact> getContacts(int gymnastId);
}
