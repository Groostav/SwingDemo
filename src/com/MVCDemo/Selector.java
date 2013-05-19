package com.MVCDemo;

public interface Selector<TElement, TReturnable> {
    public TReturnable GetFrom(TElement element);
}
