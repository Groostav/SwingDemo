package com.MVCDemo;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

import static com.MVCDemo.MVCDemoViewUtilities.*;
import static com.MVCDemo.DisplayValues.*;

/**
 * @author Geoff on 14/05/13
 */
public class ResultsView extends JComponent{

    public ResultsView(){
        setBorder(new EtchedBorder(Color.BLACK, Color.WHITE));
        setLayout(new GridLayout(10, 1));
        setPreferredSize(ResultsPanelSize);

        initializeTitle(new TitleView(ResultsViewTitle));
        initializeRSquaredBox(new NamedValueView(RSquaredTitle));
        initializeAverageBox(new NamedValueView(AverageTitle));
        initializeRunningTimeBox(new NamedValueView(ElapsedTimeTitle));
        initializeRunButton(new JButton(RunButtonIdleText));
    }

    private void initializeRunButton(JButton jButton) {
        setOrPushToIndex(this, jButton, 4);
    }
    private void initializeTitle(TitleView title){
        setOrPushToIndex(this, title, 0);
    }
    private void initializeRunningTimeBox(NamedValueView elapsedBox) {
        setOrPushToIndex(this, elapsedBox, 3);
    }
    private void initializeAverageBox(NamedValueView averageBox) {
        setOrPushToIndex(this, averageBox, 2);
        averageBox.setValueText("42.0");
    }
    private void initializeRSquaredBox(NamedValueView rSquaredBox) {
        setOrPushToIndex(this, rSquaredBox, 1);
        rSquaredBox.setValueText("0");
    }

    public JButton getRunButton(){
        return (JButton)this.getComponent(4);
    }
    public NamedValueView getRunningTimeBox(){
        return (NamedValueView)this.getComponent(3);
    }
    public NamedValueView getAverageBox(){
        return (NamedValueView)this.getComponent(2);
    }
    public NamedValueView getRSquaredBox(){
        return (NamedValueView)this.getComponent(1);
    }
}
