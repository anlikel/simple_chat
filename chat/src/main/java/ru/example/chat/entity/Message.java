package ru.example.chat.entity;

import jakarta.persistence.*;
import ru.example.chat.MessageTypes;

import java.time.LocalDateTime;

@Entity
@Table(name="messages")
public class Message {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String content;
    private String sender;
    private LocalDateTime time;
    private MessageTypes messageTypes;

    public Message(String content,String sender, LocalDateTime time,MessageTypes messageTypes){
        this.content=content;
        this.sender=sender;
        this.time=time;
        this.messageTypes=null;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public MessageTypes getMessageTypes() {
        return messageTypes;
    }

    public void setMessageTypes(MessageTypes messageTypes) {
        this.messageTypes = messageTypes;
    }
}
