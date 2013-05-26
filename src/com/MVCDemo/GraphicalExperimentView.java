package com.MVCDemo;

import javax.swing.*;
import java.awt.*;

/**
 * @author Geoff on 14/05/13
 */
public class GraphicalExperimentView extends Component {

    private Rectangle rect;

    public GraphicalExperimentView(){
        rect = new Rectangle(5, 5, 50, 50);
    }

    @Override
    public void paint(Graphics g){
        Graphics2D graphics2D = (Graphics2D)g;
        graphics2D.setColor(Color.RED);
        graphics2D.draw(rect);
        graphics2D.fill(rect);
    }

    public Rectangle getRect() {
        return rect;
    }
}
