package com.MVCDemo;

import java.awt.*;

public class ConstDimension extends Dimension {
    public ConstDimension(int width, int height){
        super(width, height);
    }
    @Override public void setSize(int width, int height) {
        assert false : "immutable dimension";
    }
}
