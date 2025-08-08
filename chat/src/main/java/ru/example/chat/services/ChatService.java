package ru.example.chat.services;

import org.springframework.stereotype.Service;
import ru.example.chat.entity.Message;
import ru.example.chat.repositores.MessageRepository;

@Service
public class ChatService {
    private final MessageRepository messageRepository;

    public ChatService(MessageRepository messageRepository){
        this.messageRepository=messageRepository;
    }

    public void saveMessage(Message message){
        messageRepository.save(message);
    }
}
