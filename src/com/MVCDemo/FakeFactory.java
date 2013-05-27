package com.MVCDemo;

import org.mockito.MockSettings;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.*;

public abstract class FakeFactory<TProductBase>{
    Map<Class<? extends TProductBase>, TProductBase> alreadyMocked;

    public FakeFactory(){
        alreadyMocked = new HashMap<Class<? extends TProductBase>, TProductBase>();
    }

    protected  <TSpecializedProduct extends TProductBase> TSpecializedProduct makeFake(Class<TSpecializedProduct> desiredProduct) {
        if(alreadyMocked.containsKey(desiredProduct)){
            return (TSpecializedProduct)alreadyMocked.get(desiredProduct);
        }
        else{
            return mockAndCache(desiredProduct, withSettings().defaultAnswer(RETURNS_DEFAULTS));
        }
    }

    private <TSpecializedProduct extends TProductBase> TSpecializedProduct mockAndCache(Class<TSpecializedProduct> desiredProduct, MockSettings settings) {
        TSpecializedProduct product = mock(desiredProduct, settings);
        alreadyMocked.put(desiredProduct, product);
        return product;
    }

    public <TSpecializedProduct extends TProductBase> TSpecializedProduct lastMade(Class<TSpecializedProduct> desiredProduct){
        return (TSpecializedProduct) alreadyMocked.get(desiredProduct);
    }
    public <TSpecializedProduct extends TProductBase> TSpecializedProduct preconfigure(Class<TSpecializedProduct> desiredProduct, MockSettings settings) {
        return mockAndCache(desiredProduct, settings);
    }

    public <TSpecializedProduct extends TProductBase> TSpecializedProduct preconfigure(Class<TSpecializedProduct> desiredProduct) {
        return mockAndCache(desiredProduct, withSettings().defaultAnswer(RETURNS_DEFAULTS));
    }
}
