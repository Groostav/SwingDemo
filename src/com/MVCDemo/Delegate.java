package com.MVCDemo;

import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Geoff on 14/05/13
 */
public class Delegate {

    public static void LogOnException(ExceptionalRunnable exceptionalRunnable) {
        try{
            exceptionalRunnable.run();
        }
        catch(Exception exception){
            exception.printStackTrace();
        }
    }
    public static <TResult> TResult LogAndYieldNullOnException(final YieldingExceptionalRunnable<TResult> exceptionalRunnable) {
        final Collection<TResult> result = new ArrayList<TResult>();
        FailOnException(new ExceptionalRunnable() {
            @Override
            public void run() throws Exception {
                result.add(exceptionalRunnable.run());
            }
        });
        return result.isEmpty() ? null : From.SetGetSingle(result);
    }

    public static void FailOnException(ExceptionalRunnable exceptionalRunnable){
        try{
            exceptionalRunnable.run();
        }
        catch(Exception exception){
            throw new RuntimeException(exception);
        }
    }
    public static <TResult> TResult FailOnException(final YieldingExceptionalRunnable<TResult> exceptionalRunnable){
        final Collection<TResult> result = new ArrayList<TResult>();
        FailOnException(new ExceptionalRunnable() {
            @Override
            public void run() throws Exception {
                result.add(exceptionalRunnable.run());
            }
        });
        return From.SetGetSingle(result);
    }
}
