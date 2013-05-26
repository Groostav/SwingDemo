package com.MVCDemo;

import com.sun.deploy.util.Property;

import java.awt.*;

/**
 * @author Geoff on 24/05/13
 */
public class WorkspaceObjectMovedEvent implements Event{

    private final Point newLocation;

    public WorkspaceObjectMovedEvent(Point newLocation){
        this.newLocation = newLocation;
    }

    public Point getNewLocation() {
        return newLocation;
    }
}
