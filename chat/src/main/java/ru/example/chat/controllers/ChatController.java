package ru.example.chat.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import ru.example.chat.entity.Message;
import ru.example.chat.services.ChatService;

import java.time.LocalDateTime;

@Controller
public class ChatController {
    private final ChatService chatService;

    public ChatController(ChatService chatService){
        this.chatService=chatService;
    }

    @MessageMapping("/chat.sendMessage")
    @SendTo("/channel/public")
    public Message sendMessage(@Payload Message message){
        message.setTime(LocalDateTime.now());
        chatService.saveMessage(message);
        return message;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/channel/public")
    public Message addUser(@Payload Message message, SimpMessageHeaderAccessor headerAccessor){
        headerAccessor.getSessionAttributes().put("username",message.getSender());
        return message;
    }
}
