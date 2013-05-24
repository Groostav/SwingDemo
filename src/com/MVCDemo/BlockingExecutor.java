package com.MVCDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author Geoff on 23/05/13
 */
public class BlockingExecutor extends AbstractExecutorService{

    private boolean isShutdown = false;
    @Override
    public synchronized void shutdown() {
        isShutdown = true;
    }

    @Override
    public synchronized List<Runnable> shutdownNow() {
        isShutdown = true;
        return new ArrayList<Runnable>();
    }

    @Override
    public synchronized boolean isShutdown() {
        return isShutdown;
    }

    @Override
    public synchronized boolean isTerminated() {
        return isShutdown;
    }

    @Override
    public synchronized boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        return true;
    }

    @Override
    public void execute(Runnable command) {
        command.run();
    }
}
