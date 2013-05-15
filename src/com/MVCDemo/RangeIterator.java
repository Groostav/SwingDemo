package com.MVCDemo;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Iterator;

public class RangeIterator implements Iterator<Integer> {
    int current;
    final int upperBound;
    public RangeIterator(int inclusiveLowerBound, int inclusiveUpperBound) {
        upperBound = inclusiveUpperBound;
        current = inclusiveLowerBound;
    }

    @Override
    public boolean hasNext() {
        return current < upperBound;
    }

    @Override
    public Integer next() {
        return current++;
    }

    @Override
    public void remove() {
        throw new NotImplementedException();
    }
}
