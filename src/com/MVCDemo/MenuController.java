package com.MVCDemo;

import com.google.common.eventbus.EventBus;

import javax.swing.*;

/**
 * @author Geoff on 14/05/13
 */
public class MenuController extends ControllerBase {

    private final MenuView view;

    public MenuController(ControllerFactory controllerFactory, ViewFactory viewFactory, EventBus eventBus){
        super(controllerFactory, viewFactory, eventBus);

        this.view = viewFactory.make(MenuView.class);
    }

    @Override
    public JComponent getView() {
        return view;
    }
}
