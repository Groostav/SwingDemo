package com.MVCDemo;

public interface Constraint<TElement> {
    public static <TStaticElement> Constraint<TStaticElement> GetTautology(){
        return new Constraint<TStaticElement>() {
            @Override
            public boolean isOK(TElement element) {
                return true;
            }
        };
    }

    public boolean isOK(TElement element);
}
