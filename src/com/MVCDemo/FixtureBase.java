package com.MVCDemo;

import org.mockito.MockSettings;
import org.mockito.Mockito;

public class FixtureBase {

    protected FakeViewFactory viewFactory;
    protected FakeControllerFactory controllerFactory;
    protected CountingEventBus eventBus;

    protected void setup(){
        eventBus = new CountingEventBus();
        controllerFactory = new FakeControllerFactory();
        viewFactory = new FakeViewFactory();
    }

    protected MockSettings toRecurisvelyMockViewObjectTree(){
        return Mockito.withSettings().defaultAnswer(Mockito.RETURNS_DEEP_STUBS);
    }
}

