package com.MVCDemo;

import javax.swing.*;
import static com.MVCDemo.Delegate.*;

/**
 * @author Geoff on 14/05/13
 */
public interface ViewFactory{
    public <TView extends JComponent> TView make(final Class<TView> targetViewClass);
}

