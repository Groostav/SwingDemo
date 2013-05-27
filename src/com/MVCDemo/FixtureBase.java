package com.MVCDemo;

import com.google.common.eventbus.EventBus;
import org.junit.Before;

public class FixtureBase {

    protected FakeViewFactory viewFactory;
    protected FakeControllerFactory controllerFactory;
    protected CountingEventBus eventBus;

    public void setup(){
        eventBus = new CountingEventBus();
        controllerFactory = new FakeControllerFactory();
        viewFactory = new FakeViewFactory();
    }
}

