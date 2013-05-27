package com.MVCDemo;

import javax.swing.*;
import java.awt.*;

/**
 * @author Geoff on 24/05/13
 */
public class NamedValueView extends JPanel {

    private JLabel title;
    private JTextField value;

    public NamedValueView(String title) {
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        GridBagConstraints constraints = layout.getConstraints(this);

        initializeTitle(title, constraints);
        initializeValue(constraints);
    }

    private void initializeTitle(String title, GridBagConstraints constraints) {
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 0.4;

        this.title = new JLabel(title);

        this.add(this.title, constraints);
    }
    private void initializeValue(GridBagConstraints constraints){
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 0.6;
        constraints.gridx = 1;
        constraints.gridy = 0;

        this.value = new JTextField();
        this.value.setEditable(false);

        this.add(this.value, constraints);
    }

    public void setTitleText(String text){
        title.setText(text);
    }
    public void setValueText(String text){
        value.setText(text);
    }
    public String getTitleText(){
        return title.getText();
    }
    public String getValueText(){
        return value.getText();
    }

}
