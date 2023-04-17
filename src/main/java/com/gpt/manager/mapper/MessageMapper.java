package com.gpt.manager.mapper;

import com.gpt.manager.model.Message;
import com.gpt.manager.model.dto.api.MessageDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MessageMapper {

    public List<MessageDto> mapToDtoList(List<Message> messageList) {
        return messageList.stream().map(message -> mapToDto(message)).toList();
    }

    public MessageDto mapToDto(Message message){
        return new MessageDto(message.getRole(), message.getContent());
    }
}
