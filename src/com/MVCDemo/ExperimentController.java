package com.MVCDemo;

import com.google.common.eventbus.EventBus;

import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * @author Geoff on 14/05/13
 */
public class ExperimentController extends ControllerBase{

    private final ExperimentsResultsModel model;
    private ExperimentView view;

    public ExperimentController(ControllerFactory controllerFactory,
                                ViewFactory viewFactory,
                                EventBus eventBus,
                                ExperimentsResultsModel model) {

        super(controllerFactory, viewFactory, eventBus);
        this.model = model;

        this.view = viewFactory.make(ExperimentView.class);

        listenForUserMovingExperiment();
    }

    private void listenForUserMovingExperiment() {
        final GraphicalExperimentView view = getView().getGraphicalExperimentView();

        view.addMouseMotionListener(new MouseInputAdapter() {
            @Override
            public void mouseDragged(MouseEvent event) {
                Point newLocation = event.getPoint();
                view.getRect().setLocation(event.getPoint());
                view.repaint();
                model.setN0(event.getX());
                eventBus.post(new WorkspaceObjectMovedEvent(newLocation));
            }
        });
    }

    @Override
    public ExperimentView getView() {
        return view;
    }
}
