package com.MVCDemo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Callable;


public class LinqingList<TElement> extends ArrayList<TElement> {

    public LinqingList<TElement> Where(Constraint<TElement> constraint){
        LinqingList<TElement> list = new LinqingList<TElement>();
        for(TElement element : this){
            if(constraint.isOK(element)){
                list.add(element);
            }
        }
        return list;
    }

    public <TReturnable> LinqingList<TReturnable> Select(Selector<TElement, TReturnable> selector){
        LinqingList<TReturnable> list = new LinqingList<TReturnable>();
        for(TElement element : this){
            list.add(selector.GetFrom(element));
        }
        return list;
    }

    public TElement Single(){
        return Single(new Constraint<TElement>() {
            @Override
            public boolean isOK(TElement element) {
                return true;
            }
        });
    }
    public TElement Single(Constraint<TElement> uniqueConstraint){

        Iterator<TElement> iterator = this.Where(uniqueConstraint).iterator();

        if(! iterator.hasNext()){
            throw new RuntimeException("Set contains no elements!");
        }

        TElement value = iterator.next();

        if(iterator.hasNext()){
            throw new RuntimeException("Set contains multiple elements!");
        }

        return value;
    }
}
