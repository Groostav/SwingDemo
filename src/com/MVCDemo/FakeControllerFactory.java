package com.MVCDemo;

public class FakeControllerFactory extends FakeFactory<Controller> implements ControllerFactory{

    @Override
    public <TController extends Controller> Controller make(Class<TController> desiredController) {
        return makeFake(desiredController);
    }
}

