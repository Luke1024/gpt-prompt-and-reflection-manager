package com.gpt.manager.model.dto;

public class ChatCreatorDto {
    private String name;
    private String type;

    public ChatCreatorDto() {
    }

    public ChatCreatorDto(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
