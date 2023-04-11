package com.gpt.manager.services;

import com.gpt.manager.model.RequestDto;
import com.gpt.manager.model.ResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiConnector {

    private String url = "https://api.openai.com/v1/chat/completions";

    @Autowired
    private Settings settings;

    private RestTemplate restTemplate = new RestTemplate();

    private Logger logger = LoggerFactory.getLogger(ApiConnector.class);

    public ResponseDto getGPTresponse(RequestDto request) throws UnsupportedOperationException{
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + settings.getKey());
        HttpEntity<RequestDto> requestHttp = new HttpEntity<>(request,headers);
        try {
            return restTemplate.postForObject(url, requestHttp,ResponseDto.class);
        } catch (Exception e){
            logger.info(e.toString());
        }
        return new ResponseDto();
    }
}
