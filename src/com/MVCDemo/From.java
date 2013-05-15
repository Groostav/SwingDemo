package com.MVCDemo;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Iterator;

/**
 * @author Geoff on 14/05/13
 */
public class From {
    public static Iterable<Integer> Range(final int inclusiveLowerBound, final int inclusiveUpperBound){
        return new Iterable<Integer>() {
            @Override
            public Iterator<Integer> iterator() {
                return new RangeIterator(inclusiveLowerBound, inclusiveUpperBound);
            }
        };
    }

    public static <TElement> TElement SetGetSingle(Iterable<TElement> set){
        Iterator<TElement> iterator = set.iterator();
        TElement value;

        if(! iterator.hasNext()){
            throw new RuntimeException("Set contains no elements!");
        }

        value = iterator.next();

        if(iterator.hasNext()){
            throw new RuntimeException("Set contains multiple elements!");
        }

        return value;
    }
}

