package com.MVCDemo;

import javax.swing.*;
import java.awt.*;

public class MVCDemoViewUtilities
{
    public static String doCoolTransformToGetRSquared(WorkspaceObjectMovedEvent event) {
        return "" + (event.getNewLocation().getX() * event.getNewLocation().getY());
    }

    public static void setOrPushToIndex(Container container, JComponent component, int targetIndex) {
        if (targetIndex < container.getComponentCount()){
            container.remove(targetIndex);
            container.add(component, targetIndex);
        }
        else if (container.getComponentCount() == targetIndex){
            container.add(component);
        }
        else{
            throw new IllegalArgumentException("target index was more than 1 greater than the size of the list; " +
                    "could not set the element at that index as that index is out of bounds, and a push of the " +
                    "element into the container would not bring the container to the required size.");
        }
    }
}
