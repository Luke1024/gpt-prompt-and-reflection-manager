package com.gpt.manager.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Settings {

    @Value("${apikey}")
    private String key;

    public String getKey() {
        return key;
    }

    //fixed settings for now
    private String model = "gpt-3.5-turbo";
    private double temperature = 0;
    private double top_p = 1;
    private int n = 1;
    private int max_tokens = 1024;
    private double presence_penalty = 0;
    private double frequency_penalty = 0;

    public String getModel() {
        return model;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getTop_p() {
        return top_p;
    }

    public int getN() {
        return n;
    }

    public int getMax_tokens() {
        return max_tokens;
    }

    public double getPresence_penalty() {
        return presence_penalty;
    }

    public double getFrequency_penalty() {
        return frequency_penalty;
    }
}
