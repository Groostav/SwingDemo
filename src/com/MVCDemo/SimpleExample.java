

package com.MVCDemo;

import com.google.common.eventbus.*;
import java.awt.event.ActionEvent;

public class SimpleExample {

    @Subscribe
    public void On(String evt) {
        System.out.println("literallyAnythingIwant String called: " + evt);
    }

    @Subscribe
    public void On(ActionEvent evt) {
        System.out.println("literallyAnythingIwant ActionEvent called: " + evt);
    }


    public static void main(String[] args) throws Exception {
        // create an event handler
        SimpleExample se = new SimpleExample();

        // subscribe it to the EventBus

        EventBus eventBus = new EventBus();
        eventBus.register(se);

        // publish some events to the bus.
        eventBus.post("Some String Event");
        eventBus.post(new ActionEvent("Fake Action Event Source", -1, "Fake Command"));

        // this shouldn't be seen, since no handler is interested in Object
        eventBus.post(new Object());

        // don't forget to unsubscribe if you're done.
        // not required in this case, since the program ends here anyway.
        eventBus.unregister(se);

        // Future messages shouldn't be seen by the SimpleExample handler after
        // being unsubscribed.
        eventBus.post("This event should not be seen after the unsubscribe call.");

    }

}

