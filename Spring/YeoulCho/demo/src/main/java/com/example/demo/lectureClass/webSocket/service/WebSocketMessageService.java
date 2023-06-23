package com.example.demo.lectureClass.webSocket.service;


import com.example.demo.lectureClass.webSocket.entity.Message;

import java.util.List;

public interface WebSocketMessageService {

    List<Message> getMessages(String room);
    Message saveMessage(Message message);
}
