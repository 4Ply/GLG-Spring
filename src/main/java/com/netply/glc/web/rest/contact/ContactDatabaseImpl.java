package com.netply.glc.web.rest.contact;

import com.netply.glc.web.rest.persistence.BaseDatabase;
import com.netply.glc.web.rest.pojo.Contact;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContactDatabaseImpl extends BaseDatabase implements ContactDatabase {
    public ContactDatabaseImpl(String mysqlIp, int mysqlPort, String mysqlDb, String mysqlUser, String mysqlPassword) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        super(mysqlIp, mysqlPort, mysqlDb, mysqlUser, mysqlPassword);
    }

    @Override
    public void addContact(Contact contact) {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement("INSERT INTO Contacts (id, first_name, surname, phone_number, alternative_phone_number, email, alternative_email) VALUES (NULL, ?, ?, ?, ?, ?, ?)")) {
            int i = 0;
            preparedStatement.setString(++i, contact.getFirstName());
            preparedStatement.setString(++i, contact.getSurname());
            preparedStatement.setString(++i, contact.getPhoneNumber());
            preparedStatement.setString(++i, contact.getAlternativePhoneNumber());
            preparedStatement.setString(++i, contact.getEmailAddress());
            preparedStatement.setString(++i, contact.getAlternativeEmailAddress());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editContact(int id, Contact contact) {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement("INSERT INTO Contacts (id, first_name, surname, phone_number, alternative_phone_number, email, alternative_email) VALUES (NULL, ?, ?, ?, ?, ?, ?) " +
                "ON DUPLICATE KEY UPDATE first_name = ?, surname = ?, phone_number = ?, alternative_phone_number = ?, email = ?, alternative_email = ?")) {
            int i = 0;
            preparedStatement.setInt(++i, id);
            preparedStatement.setString(++i, contact.getFirstName());
            preparedStatement.setString(++i, contact.getSurname());
            preparedStatement.setString(++i, contact.getPhoneNumber());
            preparedStatement.setString(++i, contact.getAlternativePhoneNumber());
            preparedStatement.setString(++i, contact.getEmailAddress());
            preparedStatement.setString(++i, contact.getAlternativeEmailAddress());

            preparedStatement.setString(++i, contact.getFirstName());
            preparedStatement.setString(++i, contact.getSurname());
            preparedStatement.setString(++i, contact.getPhoneNumber());
            preparedStatement.setString(++i, contact.getAlternativePhoneNumber());
            preparedStatement.setString(++i, contact.getEmailAddress());
            preparedStatement.setString(++i, contact.getAlternativeEmailAddress());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Contact getContact(int id) {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement("SELECT id, first_name, surname, phone_number, alternative_phone_number, email, alternative_email FROM Contacts WHERE id = ? LIMIT 1")) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Contact(resultSet.getInt("id"), resultSet.getString("first_name"), resultSet.getString("surname"), resultSet.getString("phone_number"), resultSet.getString("alternative_phone_number"), resultSet.getString("email"), resultSet.getString("alternative_email"));
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addContactLink(int gymnastId, int contactId) {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement("INSERT INTO Gymnasts_Contacts (id, gymnast_id, contact_id, primary_contact, relationship) VALUES (NULL, ?, ?, 1, '')")) {
            int i = 0;
            preparedStatement.setInt(++i, gymnastId);
            preparedStatement.setInt(++i, contactId);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteContactLink(int gymnastId, int contactId) {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement("DELETE FROM Gymnasts_Contacts WHERE gymnast_id = ? AND contact_id = ?")) {
            int i = 0;
            preparedStatement.setInt(++i, gymnastId);
            preparedStatement.setInt(++i, contactId);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Contact> getContacts() {
        List<Contact> contacts = new ArrayList<>();
        try (PreparedStatement preparedStatement = getConnection().prepareStatement("SELECT id, first_name, surname, phone_number, alternative_phone_number, email, alternative_email FROM Contacts")) {
            contacts.addAll(getContacts(preparedStatement.executeQuery()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contacts;
    }

    @Override
    public List<Contact> getContacts(int gymnastId) {
        List<Contact> contacts = new ArrayList<>();
        try (PreparedStatement preparedStatement = getConnection().prepareStatement("SELECT Contacts.id, first_name, surname, phone_number, alternative_phone_number, email, alternative_email FROM Contacts INNER JOIN Gymnasts_Contacts ON Contacts.id = Gymnasts_Contacts.contact_id WHERE Gymnasts_Contacts.gymnast_id = ?")) {
            preparedStatement.setInt(1, gymnastId);
            contacts.addAll(getContacts(preparedStatement.executeQuery()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contacts;
    }

    private List<Contact> getContacts(ResultSet resultSet) throws SQLException {
        List<Contact> contacts = new ArrayList<>();
        while (resultSet.next()) {
            contacts.add(new Contact(resultSet.getInt("id"), resultSet.getString("first_name"), resultSet.getString("surname"), resultSet.getString("phone_number"), resultSet.getString("alternative_phone_number"), resultSet.getString("email"), resultSet.getString("alternative_email")));
        }
        return contacts;
    }
}
