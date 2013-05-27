package com.MVCDemo;

import java.util.Arrays;
import java.util.Iterator;

public class FromSet{
    public static <TElement> TElement getSingleElement(Iterable<TElement> set){
        Iterator<TElement> iterator = set.iterator();

        if(! iterator.hasNext()){
            throw new RuntimeException("Set contains no elements!");
        }

        TElement value = iterator.next();

        if(iterator.hasNext()){
            throw new RuntimeException("Set contains multiple elements!");
        }

        return value;
    }
    public static <TElement> TElement getSingleElement(TElement[] set){
        return getSingleElement(Arrays.asList(set));
    }
}
