package com.MVCDemo;

public interface Constraint<TElement> {
    public boolean isOK(TElement element);
}
