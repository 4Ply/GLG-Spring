package com.netply.glc.web.rest.event;

import com.netply.glc.web.rest.pojo.Event;

import java.util.List;

public interface EventManager {
    void addEvent(Event event);

    List<Event> getEvents(int gymnastId);
}
