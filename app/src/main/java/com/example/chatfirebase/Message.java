package com.example.chatfirebase;

public class Message {
    private String text;
    private long timestamp;
    private String fromId;
    private String toId;

    public Message() {
    }

    public Message(String text, long timestamp, String fromId, String toId) {
        this.text = text;
        this.timestamp = timestamp;
        this.fromId = fromId;
        this.toId = toId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getFromId() {
        return fromId;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId;
    }

    public String getToId() {
        return toId;
    }

    public void setToId(String toId) {
        this.toId = toId;
    }
}
