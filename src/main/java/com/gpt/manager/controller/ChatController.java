package com.gpt.manager.controller;

import com.gpt.manager.mapper.MessageMapper;
import com.gpt.manager.model.Chat;
import com.gpt.manager.model.dto.ChatCreatorDto;
import com.gpt.manager.model.dto.api.MessageDto;
import com.gpt.manager.services.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/chat")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @Autowired
    private MessageMapper messageMapper;

    @PostMapping(value = "/send/{chatId}")
    public List<MessageDto> sendMessage(long chatId, MessageDto messageDto){
        return messageMapper.mapToDtoList(chatService.sendMessage(chatId, messageDto));
    }

    @GetMapping(value="/messages")
    public List<MessageDto> getMessages(long chatId){
        return messageMapper.mapToDtoList(chatService.getMessages(chatId));
    }

    @GetMapping(value = "/all")
    public List<Chat> getChats(){
        return chatService.getChats();
    }

    @PostMapping(value = "/create")
    public List<Chat> createChat(ChatCreatorDto chatCreatorDto){
        return chatService.createChat(chatCreatorDto);
    }

    @DeleteMapping(value = "/delete/{id}")
    public List<Chat> deleteChat(@PathVariable long id){
        return chatService.deleteChat(id);
    }
}
