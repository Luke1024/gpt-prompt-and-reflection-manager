package com.gpt.manager.model;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private LocalDateTime created;
    @OneToMany(targetEntity = Message.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @OrderColumn
    private List<Message> messages;

    public Chat(long id, LocalDateTime created, List<Message> messages) {
        this.id = id;
        this.created = created;
        this.messages = messages;
    }

    public long getId() {
        return id;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public List<Message> getMessages() {
        return messages;
    }
}
