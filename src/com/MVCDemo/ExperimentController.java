package com.MVCDemo;

import javax.swing.*;

/**
 * @author Geoff on 14/05/13
 */
public class ExperimentController implements Controller{
    private final ViewFactory viewFactory;
    private final EventBus eventBus;

    private ExperimentView view;

    public ExperimentController(ViewFactory viewFactory, EventBus eventBus) {

        this.viewFactory = viewFactory;
        this.eventBus = eventBus;
        this.view = viewFactory.make(ExperimentView.class);
    }

    @Override
    public JComponent getView() {
        return view;
    }
}
