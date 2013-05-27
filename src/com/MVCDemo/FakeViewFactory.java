package com.MVCDemo;

import javax.swing.*;

/**
 * @author Geoff on 26/05/13
 */
public class FakeViewFactory extends FakeFactory<JComponent> implements ViewFactory {
    @Override
    public <TView extends JComponent> TView make(Class<TView> targetViewClass) {
        return makeFake(targetViewClass);
    }
}
