package com.MVCDemo;

public interface ControllerFactory {
    public <TController extends Controller> Controller make(final Class<TController> desiredController);
}

