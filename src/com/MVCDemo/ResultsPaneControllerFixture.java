package com.MVCDemo;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.awt.*;

import static com.MVCDemo.Delegate.*;

import static org.junit.Assert.*;
import static org.junit.matchers.JUnitMatchers.*;
import static org.mockito.Mockito.*;


@RunWith(JUnit4.class)
public class ResultsPaneControllerFixture extends FixtureBase {

    ResultsPaneController controller;
    ResultsView view;

    @Before
    public void setup(){
        super.setup();
    }

    @Test
    public void when_waiting_for_time_to_pass(){
        //setup
        view = viewFactory.preconfigure(ResultsView.class);
        when(view.getRunningTimeBox()).thenReturn(new NamedValueView("testing"));

        controller = new ResultsPaneController(controllerFactory, viewFactory, eventBus);
        int startTime = Integer.parseInt(controller.getView().getRunningTimeBox().getValueText());

        //act
        FailOnException(new ExceptionalRunnable() {
            @Override
            public void run() throws Exception {
                Thread.sleep(1000);
            }
        });

        //assert
        assertEquals(0, startTime);
        int endTime = Integer.parseInt(controller.getView().getRunningTimeBox().getValueText());
        assertEquals(endTime, startTime + 1);
    }

    @Test
    public void when_rSquared_value_changes(){
        //setup
        view = viewFactory.preconfigure(ResultsView.class);
        configureViewSoElapsedTimeThreadDoesntNPE();
        when(view.getRSquaredBox()).thenReturn(mock(NamedValueView.class));

        controller = new ResultsPaneController(controllerFactory, viewFactory, eventBus);
        Point newLocation = new Point(10, 10);

        //act
        eventBus.post(new WorkspaceObjectMovedEvent(newLocation));

        //assert
        String expectedString = Double.toString(newLocation.getX() * newLocation.getY());
        verify(controller.getView().getRSquaredBox()).setValueText(expectedString);
    }

    private void configureViewSoElapsedTimeThreadDoesntNPE() {
        when(view.getRunningTimeBox()).thenReturn(new NamedValueView("testing"));
    }

}
