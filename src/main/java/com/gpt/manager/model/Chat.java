package com.gpt.manager.model;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String chatName;
    private LocalDateTime created;
    @OneToMany(targetEntity = Message.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @OrderColumn
    private List<Message> messages;
    @OneToOne(cascade = CascadeType.ALL)
    private ChatSettings chatSettings;

    public Chat(String chatName, List<Message> messages, ChatSettings chatSettings) {
        this.chatName = chatName;
        this.created = LocalDateTime.now();
        this.messages = messages;
        this.chatSettings = chatSettings;
    }

    public long getId() {
        return id;
    }

    public String getChatName() {
        return chatName;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public ChatSettings getChatSettings() {
        return chatSettings;
    }
}
