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
    private String role;
    private boolean visible;
    private boolean send;
    private boolean error;
    @ManyToOne
    @JoinColumn(name="CHAT_ID")
    private Chat chat;

    public Message(long id, LocalDateTime created, String content, String role, boolean visible, boolean send,
                   boolean error, Chat chat) {
        this.id = id;
        this.created = created;
        this.content = content;
        this.role = role;
        this.visible = visible;
        this.send = send;
        this.error = error;
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

    public String getRole() {
        return role;
    }

    public boolean isVisible() {
        return visible;
    }

    public boolean isSend() {
        return send;
    }

    public boolean isError() {
        return error;
    }

    public Chat getChat() {
        return chat;
    }
}
