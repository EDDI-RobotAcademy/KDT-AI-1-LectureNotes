package com.example.demo.lectureClass.websocket.service;

import com.example.demo.lectureClass.websocket.entity.Message;

import java.util.List;

public interface WebSocketMessageService {
    public List<Message> getMessages(String room);
    public Message saveMessage(Message message);

}
