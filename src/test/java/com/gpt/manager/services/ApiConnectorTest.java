package com.gpt.manager.services;

import com.gpt.manager.model.Message;
import com.gpt.manager.model.RequestDto;
import com.gpt.manager.model.ResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class ApiConnectorTest {

    @Autowired
    private ApiConnector apiConnector;

    @Test
    void getGPTresponse() {
        RequestDto requestDto = new RequestDto("gpt-3.5-turbo",
                Arrays.asList(new Message("user", "Hello, what's up?")),
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