package com.gpt.manager.model.dto.api;

import java.util.List;

public class ResponseDto {
    private String id;
    private String object;
    private long created;
    private List<ChoiceDto> choiceDtos;
    private UsageDto usageDto;

    public ResponseDto() {
    }

    public ResponseDto(String id, String object, long created, List<ChoiceDto> choiceDtos, UsageDto usageDto) {
        this.id = id;
        this.object = object;
        this.created = created;
        this.choiceDtos = choiceDtos;
        this.usageDto = usageDto;
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

    public List<ChoiceDto> getChoices() {
        return choiceDtos;
    }

    public UsageDto getUsage() {
        return usageDto;
    }

    @Override
    public String toString() {
        return "ResponseDto{" +
                "id='" + id + '\'' +
                ", object='" + object + '\'' +
                ", created=" + created +
                ", choices=" + choiceDtos +
                ", usage=" + usageDto +
                '}';
    }
}
