package com.gpt.manager.model.dto;

public class ChoiceDto {
    private int index;
    private MessageDto messageDto;
    private String finish_reason;

    public ChoiceDto() {
    }

    public ChoiceDto(int index, MessageDto messageDto, String finish_reason) {
        this.index = index;
        this.messageDto = messageDto;
        this.finish_reason = finish_reason;
    }

    public int getIndex() {
        return index;
    }

    public MessageDto getMessage() {
        return messageDto;
    }

    public String getFinish_reason() {
        return finish_reason;
    }

    @Override
    public String toString() {
        return "Choice{" +
                "index=" + index +
                ", message=" + messageDto +
                ", finish_reason='" + finish_reason + '\'' +
                '}';
    }
}
