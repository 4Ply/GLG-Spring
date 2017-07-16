package com.netply.glc.web.rest.transaction;

import com.netply.glc.web.rest.persistence.BaseDatabase;
import com.netply.glc.web.rest.pojo.Transaction;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransactionDatabaseImpl extends BaseDatabase implements TransactionDatabase {
    public TransactionDatabaseImpl(String mysqlIp, int mysqlPort, String mysqlDb, String mysqlUser, String mysqlPassword) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        super(mysqlIp, mysqlPort, mysqlDb, mysqlUser, mysqlPassword);
    }

    @Override
    public void addTransaction(int gymnastId, Transaction transaction) {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement("INSERT INTO Gymnasts_Transactions (gymnast_id, date, amount, payment_type, payment_method, notes) VALUES (?, ?, ?, ?, ?, ?)")) {
            int i = 0;
            preparedStatement.setInt(++i, gymnastId);
            preparedStatement.setDate(++i, Date.valueOf(transaction.getDate()));
            preparedStatement.setDouble(++i, transaction.getAmount());
            preparedStatement.setString(++i, transaction.getType());
            preparedStatement.setString(++i, transaction.getMethod());
            preparedStatement.setString(++i, transaction.getNotes());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Transaction> getTransactions(int gymnastId) {
        List<Transaction> transactions = new ArrayList<>();
        try (PreparedStatement preparedStatement = getConnection().prepareStatement("SELECT id, gymnast_id, `date`, amount, payment_type, payment_method, notes FROM Gymnasts_Transactions WHERE gymnast_id = ?")) {
            preparedStatement.setInt(1, gymnastId);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                transactions.add(new Transaction(resultSet.getInt("id"), resultSet.getInt("gymnast_id"), resultSet.getString("date"), resultSet.getDouble("amount"), resultSet.getString("payment_type"), resultSet.getString("payment_method"), resultSet.getString("notes")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transactions;
    }
}
