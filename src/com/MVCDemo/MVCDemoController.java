package com.MVCDemo;

import com.google.common.eventbus.EventBus;

/**
 * @author Geoff on 14/05/13
 */
public class MVCDemoController implements Controller {

    private MenuController menuController;
    private ResultsPaneController resultsController;
    private ExperimentController experimentController;

    private MVCDemoView view;

    private ViewFactory viewFactory;
    private EventBus eventBus;

    public MVCDemoController(ViewFactory viewFactory, EventBus eventBus){
        this.viewFactory = viewFactory;
        this.eventBus = eventBus;

        eventBus.register(this);
        view = viewFactory.make(MVCDemoView.class);

        menuController = new MenuController(viewFactory, eventBus);
        resultsController = new ResultsPaneController(viewFactory, eventBus);
        experimentController = new ExperimentController(viewFactory, eventBus);

        view.setMenuBar(menuController.getView());
        view.setResultsPanel(resultsController.getView());
        view.setExperimentPanel(experimentController.getView());
    }

    @Override
    public MVCDemoView getView() {
        return view;
    }
}

