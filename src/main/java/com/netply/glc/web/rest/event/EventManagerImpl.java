package com.netply.glc.web.rest.event;

import com.netply.glc.web.rest.pojo.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EventManagerImpl implements EventManager {
    private EventDatabase eventDatabase;


    @Autowired
    public EventManagerImpl(EventDatabase eventDatabase) {
        this.eventDatabase = eventDatabase;
    }

    @Override
    public void addEvent(Event event) {
        eventDatabase.addEvent(event);
    }

    @Override
    public List<Event> getEvents(int gymnastId) {
        return eventDatabase.getEvents(gymnastId);
    }
}
