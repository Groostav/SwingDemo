package com.MVCDemo;

import javax.swing.*;
import static com.MVCDemo.Delegate.*;

/**
 * @author Geoff on 14/05/13
 */
public class ViewFactory {

    public static JComponent emptyComponent = new JComponent() {};

    public <TView extends JComponent> TView make(final Class<TView> targetViewClass) {
        return FailOnException(new YieldingExceptionalRunnable<TView>() {
            @Override public TView run() throws Exception {return targetViewClass.newInstance();}
        });
    }


    public JFrame makeParentFrame() {
        JFrame frame = new JFrame(DisplayValues.ApplicationTitle);
        frame.setSize(DisplayValues.FrameSize);
        frame.setVisible(true);
        return frame;
    }
}
