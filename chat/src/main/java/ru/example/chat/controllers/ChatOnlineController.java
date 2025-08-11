package ru.example.chat.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.example.chat.services.ChatService;

import java.util.Set;

@RestController
@RequestMapping("/api/chat")
public class ChatOnlineController {
    private final ChatService chatService;

    public ChatOnlineController(ChatService chatService){
        this.chatService=chatService;
    }

    @GetMapping("/active-users")
    public Set<String> getActiveUsers(){
        return chatService.getActiveUsers();
    }
}