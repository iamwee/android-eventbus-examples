package com.example.zeon.eventbusexamples.event;

/**
 * Created by Zeon on 8/8/2559.
 */

public class MessageEvent {
    private String message;

    public MessageEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
