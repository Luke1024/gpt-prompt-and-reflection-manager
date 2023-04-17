package com.gpt.manager.services;

import com.gpt.manager.model.Chat;
import com.gpt.manager.model.Message;
import com.gpt.manager.model.dto.ChatCreatorDto;
import com.gpt.manager.model.dto.api.MessageDto;
import com.gpt.manager.repository.ChatRepository;
import com.gpt.manager.repository.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ChatService {

    @Autowired
    private ChatRepository chatRepository;

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private ChatCreator chatCreator;

    //chat specific senders


    private Logger logger = LoggerFactory.getLogger(ChatService.class);

    public List<Message> sendMessage(long chatId, MessageDto messageDto){
        Optional<Chat> chatOptional = chatRepository.findById(chatId);
        if(chatOptional.isPresent()){
            return useChatSpecificService(chatOptional.get(), messageDto);
        }
        return new ArrayList<>();
    }

    public List<Message> getMessages(long chatId){
        Optional<Chat> chat = chatRepository.findById(chatId);
        if(chat.isPresent()) {
            return chat.get().getMessages();
        } else {
            return new ArrayList<>();
        }
    }

    public List<Chat> getChats(){
        return (List<Chat>) chatRepository.findAll();
    }

    public List<Chat> createChat(ChatCreatorDto chatCreatorDto){
        return chatCreator.createNewChat(chatCreatorDto);
    }

    public List<Chat> deleteChat(@PathVariable long id){
        chatRepository.deleteById(id);
        return (List<Chat>) chatRepository.findAll();
    }

    private List<Message> useChatSpecificService(Chat chat, MessageDto messageDto){

        return new ArrayList<>();
    }
}
