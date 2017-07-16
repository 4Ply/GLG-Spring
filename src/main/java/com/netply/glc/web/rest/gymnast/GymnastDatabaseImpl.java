package com.netply.glc.web.rest.gymnast;

import com.netply.glc.web.rest.persistence.BaseDatabase;
import com.netply.glc.web.rest.pojo.BasicGymnast;
import com.netply.glc.web.rest.pojo.GymnastAdditional;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GymnastDatabaseImpl extends BaseDatabase implements GymnastDatabase {
    public GymnastDatabaseImpl(String mysqlIp, int mysqlPort, String mysqlDb, String mysqlUser, String mysqlPassword) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        super(mysqlIp, mysqlPort, mysqlDb, mysqlUser, mysqlPassword);
    }

    @Override
    public void addGymnast(String firstName, String surname, String identificationNumber, String dateOfBirth) {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement("INSERT INTO Gymnasts (id, first_name, surname, identification_number, date_of_birth) VALUES (NULL, ?, ?, ?, ?)")) {
            int i = 0;
            preparedStatement.setString(++i, firstName);
            preparedStatement.setString(++i, surname);
            preparedStatement.setString(++i, identificationNumber);
            preparedStatement.setString(++i, dateOfBirth);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editGymnast(int id, String firstName, String surname, String identificationNumber, String dateOfBirth) {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement("INSERT INTO Gymnasts (id, first_name, surname, identification_number, date_of_birth) VALUES (?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE first_name = ?, surname = ?, identification_number = ?, date_of_birth = ?")) {
            int i = 0;
            preparedStatement.setInt(++i, id);
            preparedStatement.setString(++i, firstName);
            preparedStatement.setString(++i, surname);
            preparedStatement.setString(++i, identificationNumber);
            preparedStatement.setString(++i, dateOfBirth);
            preparedStatement.setString(++i, firstName);
            preparedStatement.setString(++i, surname);
            preparedStatement.setString(++i, identificationNumber);
            preparedStatement.setString(++i, dateOfBirth);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public BasicGymnast getGymnast(int id) {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement("SELECT id, first_name, surname, identification_number, date_of_birth FROM Gymnasts WHERE id = ? LIMIT 1")) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new BasicGymnast(resultSet.getInt("id"), resultSet.getString("first_name"), resultSet.getString("surname"), resultSet.getString("identification_number"), resultSet.getString("date_of_birth"));
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<BasicGymnast> getGymnasts() {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement("SELECT id, first_name, surname, identification_number, date_of_birth FROM Gymnasts")) {
            List<BasicGymnast> gymnasts = new ArrayList<>();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                gymnasts.add(new BasicGymnast(resultSet.getInt("id"), resultSet.getString("first_name"), resultSet.getString("surname"), resultSet.getString("identification_number"), resultSet.getString("date_of_birth")));
            }
            return gymnasts;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    @Override
    public void editGymnastAdditional(int id, String middleName, String preferredName, String category) {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement("INSERT INTO Gymnasts_Additional (gymnast_id, middle_name, preferred_name, category) VALUES (?, ?, ?, ?) ON DUPLICATE KEY UPDATE middle_name = ?, preferred_name = ?, category = ?")) {
            int i = 0;
            preparedStatement.setInt(++i, id);
            preparedStatement.setString(++i, middleName);
            preparedStatement.setString(++i, preferredName);
            preparedStatement.setString(++i, category);

            preparedStatement.setString(++i, middleName);
            preparedStatement.setString(++i, preferredName);
            preparedStatement.setString(++i, category);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public GymnastAdditional getGymnastAdditional(int id) {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement("SELECT middle_name, preferred_name, category FROM Gymnasts_Additional WHERE gymnast_id = ? LIMIT 1")) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new GymnastAdditional(resultSet.getString("middle_name"), resultSet.getString("preferred_name"), resultSet.getString("category"));
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteGymnast(int id) {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement("DELETE FROM Gymnasts WHERE id = ?")) {
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
