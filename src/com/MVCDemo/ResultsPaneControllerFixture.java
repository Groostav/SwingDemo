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
import static com.MVCDemo.DisplayValues.*;


@RunWith(JUnit4.class)
public class ResultsPaneControllerFixture extends FixtureBase {

    ResultsPaneController controller;
    ResultsView view;

    @Before
    public void setup(){
        super.setup();
    }

    @Test //event on our event bus
    public void when_workspace_object_moves(){
        //setup
        viewFactory.preconfigure(ResultsView.class, toRecurisvelyMockViewObjectTree());
        controller = new ResultsPaneController(controllerFactory, viewFactory, eventBus);
        Point newLocation = new Point(10, 10);

        //act
        eventBus.post(new WorkspaceObjectMovedEvent(newLocation));

        //assert
        //test includes independent verification of logic in MVCDemoViewUtilities.doCoolTransformToGetRSquared()
        String expectedString = Double.toString(newLocation.getX() * newLocation.getY());
        verify(controller.getView().getRSquaredBox()).setValueText(expectedString);
    }

    @Test
    public void when_the_user_has_not_loaded_a_configuration(){
        //setup
        view = viewFactory.preconfigure(ResultsView.class, toRecurisvelyMockViewObjectTree());
        JButton button = new JButton();
        when(view.getRunButton()).thenReturn(button);

        //act
        controller = new ResultsPaneController(controllerFactory, viewFactory, eventBus);

        //assert
        assertEquals(RunButtonIdleText, button.getText());
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
        //I have searched for a goddamn listener-event package on the intertubes and I cant find one. Too many args.
        listener.mouseClicked(new MouseEvent(runButton, 0, 0, MouseEvent.BUTTON1_DOWN_MASK, 0, 0, 1, false));

        //assert
        assertEquals(RunButtonRunningText, runButton.getText());
        eventBus.shouldHaveRecieved(OptimizationStartedEvent.class);
    }

    @Test //another thread running
    public void when_waiting_for_time_to_pass(){
        //setup
        view = viewFactory.preconfigure(ResultsView.class);
        when(view.getRunningTimeBox()).thenReturn(new NamedValueView("testing-running-time-box"));
        when(view.getRSquaredBox()).thenReturn(new NamedValueView("testing-rsquared-box"));
        when(view.getRunButton()).thenReturn(new JButton());

        controller = new ResultsPaneController(controllerFactory, viewFactory, eventBus);
        waitForTimerToStart();
        int startTime = Integer.parseInt(controller.getView().getRunningTimeBox().getValueText());

        //act
        waitForASecond();

        //assert
        int endTime = Integer.parseInt(controller.getView().getRunningTimeBox().getValueText());
        assertEquals(0, startTime);
        assertEquals(endTime, startTime + 1);
    }

    private void waitForASecond() {
        FailOnException(new ExceptionalRunnable() {
            @Override
            public void run() throws Exception {
                Thread.sleep(1000);
            }
        });
    }

    private void waitForTimerToStart() {
        FailOnException(new ExceptionalRunnable() {
            @Override
            public void run() throws Exception {
                Thread.sleep(100);
            }
        });
    }
}
