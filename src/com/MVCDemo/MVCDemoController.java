package com.MVCDemo;

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

        LinqingList<Integer> list = new LinqingList<Integer>(){{add(1);add(2);add(3);add(5);add(8);add(13);}};

        LinqingList<String> newList = list.Where(new Constraint<Integer>() {
            @Override
            public boolean isOK(Integer integer) {return integer > 5;}
        })
                                          .Select(new Selector<Integer, String>() {
            @Override
            public String GetFrom(Integer integer) {
                return "" + integer;
            }
        });

        menuController = new MenuController(viewFactory, eventBus);
        resultsController = new ResultsPaneController(viewFactory, eventBus);
        experimentController = new ExperimentController(viewFactory, eventBus);

        view = viewFactory.make(MVCDemoView.class);

        view.setMenuBar(menuController.getView());
        view.setResultsPanel(resultsController.getView());
        view.setExperimentPanel(experimentController.getView());
    }

    @Override
    public MVCDemoView getView() {
        return view;
    }
}

