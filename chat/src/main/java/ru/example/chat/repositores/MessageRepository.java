package ru.example.chat.repositores;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.example.chat.entity.Message;

public interface MessageRepository extends JpaRepository<Message,Long> {
}
