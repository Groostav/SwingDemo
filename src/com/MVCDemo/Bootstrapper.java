package com.MVCDemo;

import com.adamtaft.eb.*;
import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


/**
 * @author Geoff on 14/05/13
 */
public class Bootstrapper {

    public static void main(String[] args){
        ViewFactory factory = new ViewFactory();
        EventBus eventBus = new BasicEventBus();
        MVCDemoController masterController = new MVCDemoController(factory, eventBus);

        JFrame frame = factory.makeParentFrame();

        frame.add(masterController.getView());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
    }
}
