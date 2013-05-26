package com.MVCDemo;

import org.picocontainer.MutablePicoContainer;
import org.picocontainer.PicoContainer;

public class LiveControllerFactory implements ControllerFactory{

    private MutablePicoContainer container;

    public LiveControllerFactory(MutablePicoContainer container) {
        this.container = container;
    }

    @Override
    public <TController extends Controller> Controller make(final Class<TController> desiredController) {
        TController controller = (TController) container.getComponentInstanceOfType(desiredController);
        if(controller != null){
            return controller;
        }

        container.registerComponentImplementation(desiredController);
        return (TController) container.getComponentInstanceOfType(desiredController);
    }
}
