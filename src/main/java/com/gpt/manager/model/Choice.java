package com.gpt.manager.model;

public class Choice {
    private int index;
    private Message message;
    private String finish_reason;

    public Choice() {
    }

    public Choice(int index, Message message, String finish_reason) {
        this.index = index;
        this.message = message;
        this.finish_reason = finish_reason;
    }

    public int getIndex() {
        return index;
    }

    public Message getMessage() {
        return message;
    }

    public String getFinish_reason() {
        return finish_reason;
    }

    @Override
    public String toString() {
        return "Choice{" +
                "index=" + index +
                ", message=" + message +
                ", finish_reason='" + finish_reason + '\'' +
                '}';
    }
}
