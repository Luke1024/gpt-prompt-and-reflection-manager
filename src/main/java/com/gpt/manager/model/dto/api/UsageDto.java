package com.gpt.manager.model.dto.api;

public class UsageDto {
    private int promp_tokens;
    private int completion_tokens;
    private int total_tokens;

    public UsageDto() {
    }

    public UsageDto(int promp_tokens, int completion_tokens, int total_tokens) {
        this.promp_tokens = promp_tokens;
        this.completion_tokens = completion_tokens;
        this.total_tokens = total_tokens;
    }

    public int getPromp_tokens() {
        return promp_tokens;
    }

    public int getCompletion_tokens() {
        return completion_tokens;
    }

    public int getTotal_tokens() {
        return total_tokens;
    }
}
