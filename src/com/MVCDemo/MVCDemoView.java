package com.MVCDemo;

import javax.swing.*;
import java.awt.*;

/**
 * @author Geoff on 14/05/13
 */
public class MVCDemoView extends JPanel{

    private JPanel menuBarWrapper;
    private JPanel bodyWrapper;

    public MVCDemoView(){
        super(new FlowLayout());
        Delegate.LogOnException(new ExceptionalRunnable() {
            @Override
            public void run() throws Exception {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            }
        });

        menuBarWrapper = new JPanel(){{
            setPreferredSize(DisplayValues.MenuBarWrapperSize);
            setLocation(DisplayValues.MenuLocation);
        }};

        bodyWrapper = new JPanel(){{
            setPreferredSize(DisplayValues.MainBodyArea);
            setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        }};

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(menuBarWrapper);
        add(bodyWrapper);

        setMenuBar(ViewFactory.emptyComponent);
        setExperimentPanel(ViewFactory.emptyComponent);
        setResultsPanel(ViewFactory.emptyComponent);
    }

    public JComponent getMenuBar() {
        return (JComponent)menuBarWrapper.getComponent(0);
    }

    public void setMenuBar(JComponent menuBar) {
        setOrPushToIndex(menuBarWrapper, menuBar, 0);
    }

    public JComponent getResultsPanel() {
        return (JComponent)bodyWrapper.getComponent(1);
    }

    public void setResultsPanel(JComponent resultsPanel) {
        setOrPushToIndex(bodyWrapper, resultsPanel, 1);
    }

    public JComponent getExperimentPanel() {
        return (JComponent)bodyWrapper.getComponent(0);
    }

    public void setExperimentPanel(JComponent experimentPanel) {
        setOrPushToIndex(bodyWrapper, experimentPanel, 0);
    }

    private void setOrPushToIndex(Container container, JComponent resultsPanel, int targetIndex) {
        if (targetIndex < container.getComponentCount()){
            container.remove(targetIndex);
            container.add(resultsPanel, targetIndex);
        }
        else if (container.getComponentCount() == targetIndex){
            container.add(resultsPanel, -1);
        }
        else{
            throw new IllegalArgumentException("target index was more than 1 greater than the size of the list; " +
                    "could not set the element at that index as that index is out of bounds, and a push of the " +
                    "element into the container would not bring the container to the required size.");
        }
    }
}
