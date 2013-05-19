package com.MVCDemo;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

import static com.MVCDemo.DisplayValues.*;

/**
 * @author Geoff on 14/05/13
 */
public class ResultsView extends JComponent{
    public ResultsView(){
        setBorder(new EtchedBorder(Color.BLACK, Color.WHITE));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(ResultsPanelSize);
    }
}
