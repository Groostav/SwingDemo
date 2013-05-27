package com.MVCDemo;

import com.google.common.eventbus.EventBus;
import org.hamcrest.Matcher;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.matchers.JUnitMatchers.*;


public class CountingEventBus extends EventBus {

    private static final Package googleEventBusPackage = Package.getPackage("com.google.common.eventbus");

    private List<Class> postedEvents;

    public CountingEventBus(){
        super();

        postedEvents = new ArrayList<Class>();
    }
    @Override
    public void post(Object event){
        postedEvents.add(event.getClass());
        assert event instanceof Event || isGoogleSystemEvent(event) : "counting event bus expects all published events to extend com.MVCDemo.Event, " +
                                                                      "but one was posted that does not.";
        super.post(event);
    }

    private boolean isGoogleSystemEvent(Object event) {
        return event.getClass().getPackage().equals(googleEventBusPackage);
    }

    public <TEvent extends Event> void shouldHaveRecieved(Class<TEvent> event){
        Class uppedEvent = event;
        assertThat(postedEvents, hasItem(uppedEvent));
    }
}
