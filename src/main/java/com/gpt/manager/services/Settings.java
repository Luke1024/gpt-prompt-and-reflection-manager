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
}
