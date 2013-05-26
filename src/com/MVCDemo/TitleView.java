package com.MVCDemo;

import javax.swing.*;
import java.awt.*;

/**
 * @author Geoff on 24/05/13
 */
public class TitleView extends JLabel {
    public TitleView(String titleValue) {
        super(titleValue, JLabel.CENTER);
        this.setFont(new Font("Sans Serif", Font.PLAIN, 18));
    }
}
