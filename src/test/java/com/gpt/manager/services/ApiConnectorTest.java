package com.gpt.manager.services;

import com.gpt.manager.model.dto.MessageDto;
import com.gpt.manager.model.dto.RequestDto;
import com.gpt.manager.model.dto.ResponseDto;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;


@SpringBootTest
public class ApiConnectorTest {

    @Autowired
    private ApiConnector apiConnector;

    @Disabled
    @Test
    void getGPTresponse() {
        RequestDto requestDto = new RequestDto("gpt-3.5-turbo",
                Arrays.asList(new MessageDto("user", "Hello, what's up?")),
                0.0,
                1.0,
                1,
                64,
                0.0,
                0.0);

        ResponseDto responseDto = apiConnector.getGPTresponse(requestDto);
        System.out.println(responseDto.toString());
        System.out.println(responseDto.getChoices().get(0).getMessage().toString());
    }
}