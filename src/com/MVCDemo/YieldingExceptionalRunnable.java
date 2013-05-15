package com.MVCDemo;

public interface YieldingExceptionalRunnable<TResult>{
    public TResult run() throws Exception;
}
