package com.gpt.manager.model;

import java.util.List;

public class RequestDto {
    private String model;
    private List<Message> messages;
    private Double temperature;
    private Double top_p;
    private Integer n;
    private Integer max_tokens;
    private Double presence_penalty;
    private Double frequency_penalty;

    public RequestDto() {
    }

    public RequestDto(String model, List<Message> messages, Double temperature, Double top_p, Integer n, Integer max_tokens, Double presence_penalty, Double frequency_penalty) {
        this.model = model;
        this.messages = messages;
        this.temperature = temperature;
        this.top_p = top_p;
        this.n = n;
        this.max_tokens = max_tokens;
        this.presence_penalty = presence_penalty;
        this.frequency_penalty = frequency_penalty;
    }

    public String getModel() {
        return model;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public Double getTemperature() {
        return temperature;
    }

    public Double getTop_p() {
        return top_p;
    }

    public Integer getN() {
        return n;
    }

    public Integer getMax_tokens() {
        return max_tokens;
    }

    public Double getPresence_penalty() {
        return presence_penalty;
    }

    public Double getFrequency_penalty() {
        return frequency_penalty;
    }
}
