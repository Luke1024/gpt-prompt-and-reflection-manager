package com.gpt.manager.services;

import com.gpt.manager.model.dto.api.MessageDto;
import com.gpt.manager.model.dto.api.RequestDto;
import com.gpt.manager.model.dto.api.ResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class ApiConnector {

    private String url = "https://api.openai.com/v1/chat/completions";

    @Autowired
    private Settings settings;

    private RestTemplate restTemplate = new RestTemplate();

    private Logger logger = LoggerFactory.getLogger(ApiConnector.class);

    private Optional<ResponseDto> sendToGpt(List<MessageDto> messageDtos, com.gpt.manager.model.ChatSettings chatSettings) {

        RequestDto newRequestDto = new RequestDto(
                chatSettings.getModel(),
                messageDtos,
                chatSettings.getTemperature(),
                chatSettings.getTop_p(),
                chatSettings.getN(),
                chatSettings.getMax_tokens(),
                chatSettings.getPresence_penalty(),
                chatSettings.getFrequency_penalty());

        return getGPTresponse(newRequestDto);
    }

    private Optional<ResponseDto> getGPTresponse(RequestDto request) throws UnsupportedOperationException{
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + settings.getKey());
        HttpEntity<RequestDto> requestHttp = new HttpEntity<>(request,headers);
        try {
            return Optional.of(restTemplate.postForObject(url, requestHttp,ResponseDto.class));
        } catch (Exception e){
            logger.info(e.toString());
        }
        return Optional.empty();
    }
}
