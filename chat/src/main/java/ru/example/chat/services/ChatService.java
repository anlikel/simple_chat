package ru.example.chat.services;

import org.springframework.stereotype.Service;
import ru.example.chat.entity.Message;
import ru.example.chat.repositores.MessageRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ChatService {
    private final MessageRepository messageRepository;
    private final Set<String> users=Collections.newSetFromMap(new ConcurrentHashMap<>());

    public ChatService(MessageRepository messageRepository){
        this.messageRepository=messageRepository;
    }

    public void saveMessage(Message message){
        messageRepository.save(message);
    }

    public void addUser(String username){
        users.add(username);
    }

    public void removeUser(String username){
        users.remove(username);
    }

    public Set<String> getActiveUsers(){
        return Collections.unmodifiableSet(users);
    }
}

