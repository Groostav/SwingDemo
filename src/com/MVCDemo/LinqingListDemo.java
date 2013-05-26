package com.MVCDemo;

/**
 * @author Geoff on 24/05/13
 */
public class LinqingListDemo {

    public LinqingListDemo(){
        LinqingList<Integer> list = new LinqingList<Integer>(){{add(1);add(2);add(3);add(5);add(8);add(13);}};

        LinqingList<String> newList = list.Where(new Constraint<Integer>() {
            @Override
            public boolean isOK(Integer integer) {return integer > 5;}
        })
                                          .Select(new Selector<Integer, String>() {
                    @Override
                    public String GetFrom(Integer integer) {
                        return "" + integer;
                    }
                });
    }
}
