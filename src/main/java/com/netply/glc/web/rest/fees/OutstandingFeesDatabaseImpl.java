package com.netply.glc.web.rest.fees;

import com.netply.glc.web.rest.persistence.BaseDatabase;
import com.netply.glc.web.rest.pojo.BasicGymnast;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OutstandingFeesDatabaseImpl extends BaseDatabase implements OutstandingFeesDatabase {
    public OutstandingFeesDatabaseImpl(String mysqlIp, int mysqlPort, String mysqlDb, String mysqlUser, String mysqlPassword) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        super(mysqlIp, mysqlPort, mysqlDb, mysqlUser, mysqlPassword);
    }

    @Override
    public List<BasicGymnast> getGymnastsWithOutstandingFees() {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement("SELECT Gymnasts.id, first_name, surname, identification_number, date_of_birth FROM Gymnasts " +
                "INNER JOIN Gymnasts_Transactions ON Gymnasts.id = Gymnasts_Transactions.gymnast_id WHERE gymnast_id " +
                "NOT IN (SELECT gymnast_id FROM Gymnasts_Transactions WHERE YEAR(date) = YEAR(current_timestamp) AND payment_type LIKE '2')")) {
            List<BasicGymnast> gymnasts = new ArrayList<>();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                gymnasts.add(new BasicGymnast(resultSet.getInt("id"), resultSet.getString("first_name"), resultSet.getString("surname"), resultSet.getString("identification_number"), resultSet.getString("date_of_birth"), resultSet.getString("gender")));
            }
            return gymnasts;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
