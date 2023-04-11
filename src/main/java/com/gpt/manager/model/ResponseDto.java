package com.gpt.manager.model;

import java.util.List;

public class ResponseDto {
    private String id;
    private String object;
    private long created;
    private List<Choice> choices;
    private Usage usage;

    public ResponseDto() {
    }

    public ResponseDto(String id, String object, long created, List<Choice> choices, Usage usage) {
        this.id = id;
        this.object = object;
        this.created = created;
        this.choices = choices;
        this.usage = usage;
    }

    public String getId() {
        return id;
    }

    public String getObject() {
        return object;
    }

    public long getCreated() {
        return created;
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public Usage getUsage() {
        return usage;
    }

    @Override
    public String toString() {
        return "ResponseDto{" +
                "id='" + id + '\'' +
                ", object='" + object + '\'' +
                ", created=" + created +
                ", choices=" + choices +
                ", usage=" + usage +
                '}';
    }
}
