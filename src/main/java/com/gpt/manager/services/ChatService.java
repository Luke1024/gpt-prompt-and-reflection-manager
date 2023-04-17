package com.gpt.manager.services;

import com.gpt.manager.mapper.MessageMapper;
import com.gpt.manager.model.Chat;
import com.gpt.manager.model.ChatSettings;
import com.gpt.manager.model.Message;
import com.gpt.manager.model.dto.api.MessageDto;
import com.gpt.manager.model.dto.api.RequestDto;
import com.gpt.manager.model.dto.api.ResponseDto;
import com.gpt.manager.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ChatService {

    @Autowired
    private ChatRepository chatRepository;

    @Autowired
    private ApiConnector apiConnector;

    @Autowired
    private MessageMapper messageMapper;

    @Autowired
    private SettingsService settingsService;

    public List<Chat> createNewChat(String name, List<Message> calibrationMessages, ChatSettings chatSettings){
        if(calibrationMessages==null) calibrationMessages = new ArrayList<>();
        if( ! name.isEmpty()){
            chatRepository.save(new Chat(name, calibrationMessages, chatSettings));
        }
        return (List<Chat>) chatRepository.findAll();
    }

    public List<Chat> getChats(long chatId){
        return (List<Chat>) chatRepository.findAll();
    }

    public List<Message> getMessages(long chatId){
        Optional<Chat> chat = chatRepository.findById(chatId);
        if(chat.isPresent()) {
            return chat.get().getMessages();
        } else {
            return new ArrayList<>();
        }
    }

    public List<Message> sendMessages(long chatId, MessageDto messageDto){
            Optional<Chat> chat = chatRepository.findById(chatId);
            if(chat.isPresent()) {
                Message newUserMessage = messageMapper.mapToMessage(messageDto, chat.get());
                chat.get().getMessages().add(newUserMessage);
                sendToGpt(messageDto, chat.get());
                chatRepository.save(chat.get());
                return chat.get().getMessages();
            } else {
                return new ArrayList<>();
            }
    }

    private void sendToGpt(MessageDto messageDto, Chat chat) {
        RequestDto newRequestDto = new RequestDto(
                settingsService.getModel(),
                Arrays.asList(messageDto),
                settingsService.getTemperature(),
                settingsService.getTop_p(),
                settingsService.getN(),
                settingsService.getMax_tokens(),
                settingsService.getPresence_penalty(),
                settingsService.getFrequency_penalty());

        Optional<ResponseDto> responseDto = apiConnector.getGPTresponse(newRequestDto);

        if(responseDto.isPresent()){
            Message newGptMessage = messageMapper.mapToMessage(responseDto.get().getChoices().get(0).getMessage(), chat);
            chat.getMessages().add(newGptMessage);
        } else {
            Message errorMessage = new Message("Something went wrong.",true, true, false,chat);
            errorMessage.setError(true);
            chat.getMessages().add(errorMessage);
        }
    }
}
