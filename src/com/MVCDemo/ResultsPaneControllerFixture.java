package com.MVCDemo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static com.MVCDemo.Delegate.FailOnException;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;


@RunWith(JUnit4.class)
public class ResultsPaneControllerFixture extends FixtureBase {

    ResultsPaneController controller;
    ResultsView view;

    @Before
    public void setup(){
        super.setup();
    }

    @Test //event on our event bus
    public void when_rSquared_value_changes(){
        //setup
        viewFactory.preconfigure(ResultsView.class, toRecurisvelyMockViewObjectTree());
        controller = new ResultsPaneController(controllerFactory, viewFactory, eventBus);
        Point newLocation = new Point(10, 10);

        //act
        eventBus.post(new WorkspaceObjectMovedEvent(newLocation));

        //assert
        String expectedString = Double.toString(newLocation.getX() * newLocation.getY());
        verify(controller.getView().getRSquaredBox()).setValueText(expectedString);
    }

    @Test //event on AWT listener
    public void when_the_run_button_is_hit(){
        //setup
        view = viewFactory.preconfigure(ResultsView.class, toRecurisvelyMockViewObjectTree());
        JButton runButton = new JButton();
        when(view.getRunButton()).thenReturn(runButton);

        controller = new ResultsPaneController(controllerFactory, viewFactory, eventBus);

        //act
        LinqingList<MouseListener> listeners = new LinqingList<MouseListener>(controller.getView().getRunButton().getMouseListeners());
        MouseListener listener = listeners.whereTypeIs(MouseInputAdapter.class).Single();
        listener.mouseClicked(new MouseEvent(runButton, 0, 0, MouseEvent.MOUSE_CLICKED, 0, 0, 1, false));

        //assert
        assertEquals(DisplayValues.RunButtonRunningText, runButton.getText());
        eventBus.shouldHaveRecieved(OptimizationStartedEvent.class);
    }

    @Test //another thread running
    public void when_waiting_for_time_to_pass(){
        //setup
        view = viewFactory.preconfigure(ResultsView.class, toRecurisvelyMockViewObjectTree());
        when(view.getRunningTimeBox()).thenReturn(new NamedValueView("testing-running-time-box"));
        when(view.getRSquaredBox()).thenReturn(new NamedValueView("testing-rsquared-box"));
        when(view.getRunButton()).thenReturn(new JButton());

        controller = new ResultsPaneController(controllerFactory, viewFactory, eventBus);
        FailOnException(new ExceptionalRunnable() {
            @Override
            public void run() throws Exception {
                //need to let the timer thread start
                Thread.sleep(100);
            }
        });
        int startTime = Integer.parseInt(controller.getView().getRunningTimeBox().getValueText());

        //act
        FailOnException(new ExceptionalRunnable() {
            @Override
            public void run() throws Exception {
                Thread.sleep(1000);
            }
        });

        //assert
        int endTime = Integer.parseInt(controller.getView().getRunningTimeBox().getValueText());
        assertEquals(0, startTime);
        assertEquals(endTime, startTime + 1);
    }

}
