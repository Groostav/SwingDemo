package com.MVCDemo;

import com.google.common.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.matchers.JUnitMatchers.*;


public class CountingEventBus extends EventBus {

    private List<Object> postedEvents;

    public CountingEventBus(){
        super();

        postedEvents = new ArrayList<Object>();
    }
    @Override
    public void post(Object event){
        postedEvents.add(event);
        assert event instanceof Event : "counting event bus expects all published events to extend com.MVCDemo.Event, " +
                                        "but one was posted that does not.";
        super.post(event);
    }

    public void shouldHaveRecieved(Event event){
        assertThat(postedEvents, hasItem((Object)event));
    }
}
