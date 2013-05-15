package com.MVCDemo;

public interface EventHandler<TEvent extends Event>{
    public void OnEvent(TEvent event);
}
