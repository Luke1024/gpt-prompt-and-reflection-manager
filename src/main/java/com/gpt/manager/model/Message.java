package com.gpt.manager.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private LocalDateTime created;
    private String content;
    private boolean visible;
    @ManyToOne
    @JoinColumn(name="CHAT_ID")
    private Chat chat;

    public Message(LocalDateTime created, String content, boolean visible, Chat chat) {
        this.created = created;
        this.content = content;
        this.visible = visible;
        this.chat = chat;
    }

    public long getId() {
        return id;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public String getContent() {
        return content;
    }

    public boolean isVisible() {
        return visible;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }
}
