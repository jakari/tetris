package org.janitor.tetris.model.event;

import java.util.ArrayList;

/**
 * The event handles a collection of eventlisteners and may send messages to these
 * listeners.
 */
public class EventDispatcher {
    private ArrayList<EventListener> listeners;

    /**
     * The constructor.
     */
    public EventDispatcher() {
        listeners = new ArrayList<>();
    }

    /**
     * Adds a listener into the event dispatcher.
     * @param e listener to add.
     */
    public void addListener(EventListener e) {
        listeners.add(e);
    }

    /**
     * Dispatches event.
     */
    public void dispatch() {
        // Todo
    }
}
