package com.MVCDemo;

import com.google.common.eventbus.EventBus;

public abstract class ControllerBase{
    protected final ViewFactory viewFactory;
    protected final EventBus eventBus;

    protected ControllerBase(ViewFactory viewFactory, EventBus eventBus){

        this.viewFactory = viewFactory;
        this.eventBus = eventBus;

        this.eventBus.register(this);
    }
}
