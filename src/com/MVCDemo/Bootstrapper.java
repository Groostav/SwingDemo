package com.MVCDemo;

import com.google.common.eventbus.EventBus;
import org.picocontainer.*;
import org.picocontainer.defaults.DefaultPicoContainer;

import javax.swing.*;


/**
 * @author Geoff on 14/05/13
 */

public class Bootstrapper {

    private static MutablePicoContainer container;

    public static void main(String[] args){

        container = new DefaultPicoContainer();
        registerComponents();

        ControllerFactory controllerFactory = (ControllerFactory) container.getComponentInstanceOfType(ControllerFactory.class);
        Controller masterController = controllerFactory.make(MVCDemoController.class);

        JFrame frame = new JFrame();

        ConfigureFrame(masterController.getView(), frame);
    }

    private static void ConfigureFrame(JComponent content, JFrame frame) {
        frame.add(content);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setMinimumSize(DisplayValues.FrameSize);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    private static void registerComponents() {
        container.registerComponentInstance(container);
        container.registerComponentImplementation(EventBus.class);
        container.registerComponentImplementation(ViewFactory.class, LiveViewFactory.class);
        container.registerComponentImplementation(ControllerFactory.class, LiveControllerFactory.class);
    }
}
