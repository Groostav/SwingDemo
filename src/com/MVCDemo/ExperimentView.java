package com.MVCDemo;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

/**
 * @author Geoff on 14/05/13
 */
public class ExperimentView extends JPanel{

    private final GraphicalExperimentView graphicalExperimentView;

    public ExperimentView(){
        setBackground(Color.LIGHT_GRAY);
        setBorder(new EtchedBorder(Color.BLACK, Color.WHITE));
        setPreferredSize(DisplayValues.ExparimentBoxSize);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.graphicalExperimentView = new GraphicalExperimentView();
        add(this.graphicalExperimentView);
    }

    public GraphicalExperimentView getGraphicalExperimentView(){
        return graphicalExperimentView;
    }



}
