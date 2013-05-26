package com.MVCDemo;

import com.google.common.eventbus.EventBus;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.MouseEvent;

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

        attachExperimentDraggingListener();
    }

    private void attachExperimentDraggingListener() {
        final GraphicalExperimentView view = getView().getGraphicalExperimentView();

        view.addMouseMotionListener(new MouseInputAdapter() {
            @Override
            public void mouseDragged(MouseEvent event) {
                Point newLocation = event.getPoint();
                view.getRect().setLocation(event.getPoint());
                view.repaint();
                eventBus.post(new WorkspaceObjectMovedEvent(newLocation));
            }
        });
    }

    @Override
    public ExperimentView getView() {
        return view;
    }
}
