package com.netply.glc.web.rest;

import com.netply.glc.web.rest.event.EventManager;
import com.netply.glc.web.rest.pojo.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class EventController {
    private EventManager eventManager;


    @Autowired
    public EventController(EventManager eventManager) {
        this.eventManager = eventManager;
    }

    @RequestMapping(value = "/events", produces = "application/json", method = RequestMethod.GET)
    @ResponseBody
    public List<Event> getEvents(
            @RequestParam(value = "gymnastId") Integer gymnastId) {
        return eventManager.getEvents(gymnastId).stream().distinct().collect(Collectors.toList());
    }
}
