package com.MVCDemo;

import com.google.common.eventbus.EventBus;

import javax.swing.*;


/**
 * @author Geoff on 14/05/13
 */
public class Bootstrapper {

    public static void main(String[] args){
        ViewFactory factory = new ViewFactory();
        EventBus eventBus = new EventBus();

        MVCDemoController masterController = new MVCDemoController(factory, eventBus);

        JFrame frame = factory.makeParentFrame();

        frame.add(masterController.getView());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
    }
}
