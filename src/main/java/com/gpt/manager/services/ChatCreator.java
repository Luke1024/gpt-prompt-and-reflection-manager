package com.gpt.manager.services;

import com.gpt.manager.model.Chat;
import com.gpt.manager.model.ChatSettings;
import com.gpt.manager.model.dto.ChatCreatorDto;
import com.gpt.manager.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatCreator {

    @Autowired
    private ChatRepository chatRepository;

    @Autowired
    private Settings defaultSettings;

    public List<Chat> createNewChat(ChatCreatorDto chatCreatorDto){
        if( ! chatCreatorDto.getName().isEmpty()){
            Chat newChat = buildChat(chatCreatorDto);
            chatRepository.save(newChat);
        }
        return (List<Chat>) chatRepository.findAll();
    }

    private Chat buildChat(ChatCreatorDto chatCreatorDto){
        return new Chat(
                chatCreatorDto.getName(),
                new ChatSettings(
                        defaultSettings.getModel(),
                        defaultSettings.getTemperature(),
                        defaultSettings.getTop_p(),
                        defaultSettings.getN(),
                        defaultSettings.getMax_tokens(),
                        defaultSettings.getPresence_penalty(),
                        defaultSettings.getFrequency_penalty()
                )
        );
    }
}
