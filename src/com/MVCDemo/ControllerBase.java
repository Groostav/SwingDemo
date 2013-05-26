package com.MVCDemo;

import com.google.common.eventbus.EventBus;

import javax.swing.*;

public abstract class ControllerBase implements Controller{
    protected final ControllerFactory controllerFactory;
    protected final ViewFactory viewFactory;
    protected final EventBus eventBus;

    protected ControllerBase(ControllerFactory controllerFactory, ViewFactory viewFactory, EventBus eventBus){
        this.controllerFactory = controllerFactory;
        this.viewFactory = viewFactory;
        this.eventBus = eventBus;

        this.eventBus.register(this);
    }

    @Override public abstract JComponent getView();
}
