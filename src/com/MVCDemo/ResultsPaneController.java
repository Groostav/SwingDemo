package com.MVCDemo;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

import javax.swing.*;
import java.util.Calendar;

/**
 * @author Geoff on 14/05/13
 */
public class ResultsPaneController extends ControllerBase{

    private final ResultsView view;
    private int time;

    public ResultsPaneController(ControllerFactory controllerFactory, ViewFactory viewFactory, EventBus eventBus) {
        super(controllerFactory, viewFactory, eventBus);

        this.view = viewFactory.make(ResultsView.class);

        initializeElapsedTimeThread();
    }

    private void initializeElapsedTimeThread() {
        time = 0;
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    updateTime();
                    clockWait();
                }
            }
        });
        thread.start();
    }

    private void clockWait() {
        Delegate.FailOnException(new ExceptionalRunnable() {
            @Override
            public void run() throws Exception {
                Thread.sleep(1000);
            }
        });
    }

    private void updateTime() {
        view.getRunningTimeBox().setValueText("" + time);
        time += 1;
    }

    @Subscribe
    public void On(WorkspaceObjectMovedEvent event){
        String newRSquaredText = MVCDemoViewUtilities.doCoolTransformToGetRSquared(event);
        view.getRSquaredBox().setValueText(newRSquaredText);
    }

    @Override
    public JComponent getView() {
        return view;
    }
}

