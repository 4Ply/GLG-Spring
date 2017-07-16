package com.netply.glc.web.rest.event;

import com.netply.glc.web.rest.persistence.BaseDatabase;
import com.netply.glc.web.rest.pojo.Event;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EventDatabaseImpl extends BaseDatabase implements EventDatabase {
    public EventDatabaseImpl(String mysqlIp, int mysqlPort, String mysqlDb, String mysqlUser, String mysqlPassword) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        super(mysqlIp, mysqlPort, mysqlDb, mysqlUser, mysqlPassword);
    }

    @Override
    public void addEvent(Event event) {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement("INSERT INTO Gymnasts_Events (id, date, event_type) VALUES (NULL, ?, ?)")) {
            int i = 0;
            preparedStatement.setString(++i, event.getDate());
            preparedStatement.setString(++i, event.getType());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Event> getEvents(int gymnastId) {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement("SELECT id, `date`, event_type FROM Gymnasts_Events WHERE gymnast_id = ?")) {
            preparedStatement.setInt(1, gymnastId);

            ResultSet resultSet = preparedStatement.executeQuery();
            List<Event> events = new ArrayList<>();
            while (resultSet.next()) {
                events.add(new Event(resultSet.getInt("id"), resultSet.getString("date"), resultSet.getString("event_type")));
            }
            return events;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
