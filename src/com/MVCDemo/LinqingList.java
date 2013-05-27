package com.MVCDemo;

import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;


public class LinqingList<TElement> extends ArrayList<TElement> {

    public LinqingList(){
        super();
    }
    public LinqingList(TElement... elements) {
        this(Arrays.asList(elements));
    }
    public LinqingList(Collection<TElement> elements) {
        super(elements);
    }

    public <TReturnable> LinqingList<TReturnable> Select(Selector<TElement, TReturnable> selector){
        LinqingList<TReturnable> list = new LinqingList<TReturnable>();
        for(TElement element : this){
            list.add(selector.GetFrom(element));
        }
        return list;
    }

    public LinqingList<TElement> Where(Constraint<TElement> constraint){
        LinqingList<TElement> list = new LinqingList<TElement>();
        for(TElement element : this){
            if(constraint.isOK(element)){
                list.add(element);
            }
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

        Iterable<TElement> restrictedSet = this.Where(uniqueConstraint);

        return FromSet.getSingleElement(restrictedSet);
    }

    public <TDesired extends TElement> LinqingList<TDesired> whereTypeIs(Class<TDesired> desiredClass) {
        LinqingList<TDesired> list = new LinqingList<TDesired>();
        for(TElement element : this){
            if(desiredClass.isAssignableFrom(element.getClass())){
                list.add((TDesired)element);
            }
        }
        return list;
    }
}

