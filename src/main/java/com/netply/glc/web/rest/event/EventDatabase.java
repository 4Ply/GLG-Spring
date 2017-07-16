package com.netply.glc.web.rest.event;

import com.netply.glc.web.rest.pojo.Event;

import java.util.List;

public interface EventDatabase {
    void addEvent(Event event);

    List<Event> getEvents(int gymnastId);
}
