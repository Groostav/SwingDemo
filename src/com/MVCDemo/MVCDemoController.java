package com.MVCDemo;

import com.google.common.eventbus.EventBus;

/**
 * @author Geoff on 14/05/13
 */
public class MVCDemoController extends ControllerBase{

    private Controller menuController;
    private Controller resultsController;
    private Controller experimentController;

    private MVCDemoView view;

    public MVCDemoController(ControllerFactory controllerFactory, ViewFactory viewFactory, EventBus eventBus){
        super(controllerFactory, viewFactory, eventBus);

        view = viewFactory.make(MVCDemoView.class);

        menuController = controllerFactory.make(MenuController.class);
        resultsController = controllerFactory.make(ResultsPaneController.class);
        experimentController = controllerFactory.make(ExperimentController.class);

        view.setMenuBar(menuController.getView());
        view.setResultsPanel(resultsController.getView());
        view.setExperimentPanel(experimentController.getView());
    }

    @Override
    public MVCDemoView getView() {
        return view;
    }
}

