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
    private boolean send;
    private boolean byUser;
    private boolean error;
    @ManyToOne
    @JoinColumn(name="CHAT_ID")
    private Chat chat;

    public Message(String content, boolean visible, boolean send, boolean byUser, Chat chat) {
        this.created = LocalDateTime.now();
        this.content = content;
        this.visible = visible;
        this.send = send;
        this.byUser = byUser;
        this.error = false;
        this.chat = chat;
    }

    public boolean isError() {
        return error;
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

    public boolean isSend() {
        return send;
    }

    public boolean isByUser() {
        return byUser;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public void setError(boolean error) {
        this.error = error;
    }
}
