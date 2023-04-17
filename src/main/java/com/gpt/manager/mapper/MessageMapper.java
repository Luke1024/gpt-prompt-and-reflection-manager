package com.gpt.manager.mapper;

import com.gpt.manager.model.Chat;
import com.gpt.manager.model.Message;
import com.gpt.manager.model.dto.api.MessageDto;
import org.springframework.stereotype.Component;

@Component
public class MessageMapper {

    public Message mapToMessage(MessageDto messageDto, Chat chat){
        return new Message(messageDto.getContent(),
                true,
                false,
                true,
                chat);
    }
}
