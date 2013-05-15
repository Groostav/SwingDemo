package com.MVCDemo;

import com.sun.management.GarbageCollectionNotificationInfo;

import javax.management.Notification;
import javax.management.NotificationEmitter;
import javax.management.NotificationListener;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unchecked") // WeakReferences are unsafe.
public class EventBus {

    Map<Class<? extends Event>, List<EventHandler>> handlersByEvent;
    Map<WeakReference, List<EventHandler>> handlersByReceiver;

    public EventBus(){
        handlersByEvent = new HashMap<Class<? extends Event>, List<EventHandler>>();
        handlersByReceiver = new HashMap<WeakReference, List<EventHandler>>();
    }

    public void handleWith(Object receiver, Class<? extends Event> eventType, EventHandler handler){
        ensureValueListExists(handlersByEvent, eventType);
        handlersByEvent.get(eventType).add(handler);

        WeakReference key = getSafelyReferencableValue(receiver);
        ensureValueListExists(handlersByReceiver, key);
        handlersByReceiver.get(key).add(handler);
    }

    private WeakReference getSafelyReferencableValue(Object receiver) {
        return new WeakReference(receiver);
    }

    private <TKey, TValueElement> void ensureValueListExists(Map<TKey, List<TValueElement>> map, TKey key){
        if(map.containsKey(key) && map.get(key) != null){
            return;
        }

        map.put(key, new ArrayList<TValueElement>());
    }


    public void publish(Event event){
        for(EventHandler handler : handlersByEvent.get(event.getClass())){
            handler.OnEvent(event);
        }
    }

    public void installGCMonitoring(){

        for (GarbageCollectorMXBean gcbean : ManagementFactory.getGarbageCollectorMXBeans()) {

            NotificationEmitter emitter = (NotificationEmitter) gcbean;

            NotificationListener listener = new NotificationListener() {
                @Override
                public void handleNotification(Notification notification, Object handback) {
                    if (isGarbageCollectionEvent(notification)) {
                        removeDeadReceivers();
                    }
                }

                private boolean isGarbageCollectionEvent(Notification notification) {
                    return notification.getType().equals(GarbageCollectionNotificationInfo.GARBAGE_COLLECTION_NOTIFICATION);
                }
            };

            //Add the listener
            emitter.addNotificationListener(listener, null, null);
        }
    }

    private void removeDeadReceivers() {
        for(WeakReference reference : handlersByReceiver.keySet()){
            if(reference.get() != null){
                return;
            }

            RemoveHandler(reference);
        }
    }

    private void RemoveHandler(WeakReference defunctReciever) {
        for(EventHandler defunctHandler : handlersByReceiver.get(defunctReciever)){
            for(List<EventHandler> candidates : handlersByEvent.values()){
                candidates.remove(defunctHandler);
            }
        }
    }
}
