package com.MVCDemo;

import javax.swing.*;

/**
 * @author Geoff on 14/05/13
 */
public class ResultsPaneController implements Controller{
    private final ViewFactory viewFactory;
    private final EventBus eventBus;
    private final ResultsView view;

    public ResultsPaneController(ViewFactory viewFactory, EventBus eventBus) {

        this.viewFactory = viewFactory;
        this.eventBus = eventBus;
        this.view = viewFactory.make(ResultsView.class);
    }

    @Override
    public JComponent getView() {
        return new JPanel();
    }
}
