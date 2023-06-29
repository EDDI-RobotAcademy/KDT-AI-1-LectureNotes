package com.example.demo.lectureClass.websocket.service;

import com.example.demo.lectureClass.websocket.entity.Message;

import java.util.List;

public interface WebSocketMessageService {

    List<Message> getMessages(String room);
    Message saveMessage(Message message);
}
