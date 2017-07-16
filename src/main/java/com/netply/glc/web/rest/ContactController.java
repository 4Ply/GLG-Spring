package com.netply.glc.web.rest;

import com.netply.glc.web.rest.contact.ContactManager;
import com.netply.glc.web.rest.pojo.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactController {
    private ContactManager contactManager;


    @Autowired
    public ContactController(ContactManager contactManager) {
        this.contactManager = contactManager;
    }

    @RequestMapping(value = "/contact", consumes = "application/json", produces = "application/json", method = RequestMethod.PUT)
    public void addContact(
            @RequestParam(value = "firstName") String firstName,
            @RequestParam(value = "surname") String surname,
            @RequestParam(value = "phoneNumber") String phoneNumber,
            @RequestParam(value = "alternativePhoneNumber") String alternativePhoneNumber,
            @RequestParam(value = "emailAddress") String emailAddress,
            @RequestParam(value = "alternativeEmailAddress") String alternativeEmailAddress) {
        contactManager.addContact(new Contact(firstName, surname, phoneNumber, alternativePhoneNumber, emailAddress, alternativeEmailAddress));
    }

    @RequestMapping(value = "/contact", consumes = "application/json", produces = "application/json", method = RequestMethod.POST)
    public void editContact(
            @RequestParam(value = "id") Integer id,
            @RequestBody Contact contact) {
        contactManager.editContact(id, contact);
    }

    @RequestMapping(value = "/contactLink", consumes = "application/json", produces = "application/json", method = RequestMethod.PUT)
    public void linkContact(
            @RequestParam(value = "gymnastId") Integer gymnastId,
            @RequestParam(value = "contactId") Integer contactId) {
        contactManager.addContactLink(gymnastId, contactId);
    }

    @RequestMapping(value = "/contactLink", consumes = "application/json", produces = "application/json", method = RequestMethod.DELETE)
    public void deleteContactLink(
            @RequestParam(value = "gymnastId") Integer gymnastId,
            @RequestParam(value = "contactId") Integer contactId) {
        contactManager.deleteContactLink(gymnastId, contactId);
    }

    @RequestMapping(value = "/contact", produces = "application/json", method = RequestMethod.GET)
    @ResponseBody
    public Contact getContact(
            @RequestParam(value = "id") Integer id) {
        return contactManager.getContact(id);
    }

    @RequestMapping(value = "/contacts", produces = "application/json", method = RequestMethod.GET)
    @ResponseBody
    public List<Contact> getContacts(
            @RequestParam(value = "gymnastId", required = false) Integer gymnastId) {
        return gymnastId == null ? contactManager.getContacts() : contactManager.getContacts(gymnastId);
    }
}
