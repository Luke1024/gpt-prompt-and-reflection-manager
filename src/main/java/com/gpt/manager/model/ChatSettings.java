package com.gpt.manager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class ChatSettings {

    @Id
    @GeneratedValue
    private long id;

    private String model;
    private Double temperature;
    private Double top_p;
    private Integer n;
    private Integer max_tokens;
    private Double presence_penalty;
    private Double frequency_penalty;

    public ChatSettings(String model, Double temperature, Double top_p, Integer n, Integer max_tokens,
                        Double presence_penalty, Double frequency_penalty) {
        this.temperature = temperature;
        this.top_p = top_p;
        this.n = n;
        this.max_tokens = max_tokens;
        this.presence_penalty = presence_penalty;
        this.frequency_penalty = frequency_penalty;
    }

    public long getId() {
        return id;
    }

    public String getModel() {
        return model;
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
