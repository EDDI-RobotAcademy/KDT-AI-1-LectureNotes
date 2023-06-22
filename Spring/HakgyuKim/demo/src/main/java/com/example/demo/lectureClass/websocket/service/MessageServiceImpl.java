package com.example.demo.lectureClass.websocket.service;

import com.example.demo.lectureClass.websocket.entity.Message;
import com.example.demo.lectureClass.websocket.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService{

    final private MessageRepository messageRepository;
    @Override
    public List<Message> getMessages(String room) {
        return messageRepository.findAllByRoom(room);
    }

    @Override
    public Message saveMessage(Message message) {
        return messageRepository.save(message);
    }
}
