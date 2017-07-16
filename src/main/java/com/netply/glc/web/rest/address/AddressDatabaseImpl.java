package com.netply.glc.web.rest.address;

import com.netply.glc.web.rest.persistence.BaseDatabase;
import com.netply.glc.web.rest.pojo.Address;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressDatabaseImpl extends BaseDatabase implements AddressDatabase {
    public AddressDatabaseImpl(String mysqlIp, int mysqlPort, String mysqlDb, String mysqlUser, String mysqlPassword) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        super(mysqlIp, mysqlPort, mysqlDb, mysqlUser, mysqlPassword);
    }

    @Override
    public void editAddress(int gymnastId, Address address) {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement("INSERT INTO Gymnasts_Address (id, gymnast_id, address_line_1, address_line_2, address_line_3, address_code, school) VALUES (NULL, ?, ?, ?, ?, ?, ?) " +
                "ON DUPLICATE KEY UPDATE address_line_1 = ?, address_line_2 = ?, address_line_3 = ?, address_code = ?, school = ?")) {
            int i = 0;
            preparedStatement.setInt(++i, gymnastId);
            preparedStatement.setString(++i, address.getAddressLine1());
            preparedStatement.setString(++i, address.getAddressLine2());
            preparedStatement.setString(++i, address.getAddressLine3());
            preparedStatement.setString(++i, address.getAddressCode());
            preparedStatement.setString(++i, address.getSchool());

            preparedStatement.setString(++i, address.getAddressLine1());
            preparedStatement.setString(++i, address.getAddressLine2());
            preparedStatement.setString(++i, address.getAddressLine3());
            preparedStatement.setString(++i, address.getAddressCode());
            preparedStatement.setString(++i, address.getSchool());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Address getAddress(int gymnastId) {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement("SELECT address_line_1, address_line_2, address_line_3, address_code, school FROM Gymnasts_Address WHERE gymnast_id = ? LIMIT 1")) {
            preparedStatement.setInt(1, gymnastId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Address(resultSet.getString("address_line_1"), resultSet.getString("address_line_2"), resultSet.getString("address_line_3"), resultSet.getString("address_code"), resultSet.getString("school"));
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
