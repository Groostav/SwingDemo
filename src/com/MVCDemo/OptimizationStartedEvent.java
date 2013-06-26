package com.MVCDemo;

/**
 * @author Geoff on 23/05/13
 */
public class OptimizationStartedEvent implements Event {
    public OptimizationStartedEvent(int timeWhenStarted) {
        this.timeWhenStarted = timeWhenStarted;
    }

    final int timeWhenStarted;
}
