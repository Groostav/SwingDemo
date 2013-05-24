package com.MVCDemo;

import com.adamtaft.eb.EventBus;

import javax.swing.*;

/**
 * @author Geoff on 14/05/13
 */
public class MenuController implements Controller {

    private final ViewFactory viewFactory;
    private final EventBus eventBus;

    private final MenuView view;

    public MenuController(ViewFactory viewFactory, EventBus eventBus){
        this.viewFactory = viewFactory;
        this.eventBus = eventBus;

        this.view = viewFactory.make(MenuView.class);
    }

    @Override
    public JComponent getView() {
        return view;
    }
}
