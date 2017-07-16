package com.netply.glc.web.rest.contact;

import com.netply.glc.web.rest.pojo.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ContactManagerImpl implements ContactManager {
    private ContactDatabase contactDatabase;


    @Autowired
    public ContactManagerImpl(ContactDatabase contactDatabase) {
        this.contactDatabase = contactDatabase;
    }

    @Override
    public void addContact(Contact contact) {
        contactDatabase.addContact(contact);
    }

    @Override
    public void editContact(int id, Contact contact) {
        contactDatabase.editContact(id, contact);
    }

    @Override
    public Contact getContact(int id) {
        return contactDatabase.getContact(id);
    }

    @Override
    public void addContactLink(int gymnastId, int contactId) {
        contactDatabase.addContactLink(gymnastId, contactId);
    }

    @Override
    public void deleteContactLink(int gymnastId, int contactId) {
        contactDatabase.deleteContactLink(gymnastId, contactId);
    }

    @Override
    public List<Contact> getContacts() {
        return contactDatabase.getContacts();
    }

    @Override
    public List<Contact> getContacts(int gymnastId) {
        return contactDatabase.getContacts(gymnastId);
    }
}
