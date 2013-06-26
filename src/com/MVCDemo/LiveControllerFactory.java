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
        TController controller = tryMake(desiredController);
        if(controller != null){
            return controller;
        }

        container.registerComponentImplementation(desiredController);
        //TODO:
        //i either need to register model providers, which makes some ammount of sense
        // or i need to temporarily register the models themselves... which has be doing Object... params, or having them implement an empty interface and having EmptyInterface...params,
        // or I avoid an IOC container all together.
        // or...?

        return tryMake(desiredController);
    }

    private <TController extends Controller> TController tryMake(Class<TController> desiredController) {
        return (TController) container.getComponentInstanceOfType(desiredController);
    }
}
