package com.rsbuddy.osrs.event;

import java.util.Objects;

public class SendChatMessage {
    private final String message;

    private boolean consumed = false;

    public SendChatMessage(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }

    public boolean isConsumed() {
        return consumed;
    }

    public void consume() {
        consumed = true;
    }

    @Override
    public String toString() {
        return "SendChatMessage{" +
                "message='" + message + '\'' +
                ", consumed=" + consumed +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SendChatMessage that = (SendChatMessage) o;
        return consumed == that.consumed &&
                Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, consumed);
    }
}
