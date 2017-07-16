package com.netply.glc.web.rest.medical;

import com.netply.glc.web.rest.persistence.BaseDatabase;
import com.netply.glc.web.rest.pojo.MedicalInformation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MedicalDatabaseImpl extends BaseDatabase implements MedicalDatabase {
    public MedicalDatabaseImpl(String mysqlIp, int mysqlPort, String mysqlDb, String mysqlUser, String mysqlPassword) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        super(mysqlIp, mysqlPort, mysqlDb, mysqlUser, mysqlPassword);
    }

    @Override
    public void editMedical(int gymnastId, MedicalInformation medicalInformation) {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement("INSERT INTO Gymnasts_Medical (id, gymnast_id, medical_aid_name, medical_aid_number, physical_disabilities) VALUES (NULL, ?, ?, ?, ?) " +
                "ON DUPLICATE KEY UPDATE medical_aid_name = ?, medical_aid_number = ?, physical_disabilities = ?")) {
            int i = 0;
            preparedStatement.setInt(++i, gymnastId);
            preparedStatement.setString(++i, medicalInformation.getMedicalAidName());
            preparedStatement.setString(++i, medicalInformation.getMedicalAidNumber());
            preparedStatement.setString(++i, medicalInformation.getPhysicalDisabilities());

            preparedStatement.setString(++i, medicalInformation.getMedicalAidName());
            preparedStatement.setString(++i, medicalInformation.getMedicalAidNumber());
            preparedStatement.setString(++i, medicalInformation.getPhysicalDisabilities());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public MedicalInformation getMedical(int gymnastId) {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement("SELECT medical_aid_name, medical_aid_number, physical_disabilities FROM Gymnasts_Medical WHERE gymnast_id = ? LIMIT 1")) {
            preparedStatement.setInt(1, gymnastId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new MedicalInformation(resultSet.getString("medical_aid_name"), resultSet.getString("medical_aid_number"), resultSet.getString("physical_disabilities"));
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
