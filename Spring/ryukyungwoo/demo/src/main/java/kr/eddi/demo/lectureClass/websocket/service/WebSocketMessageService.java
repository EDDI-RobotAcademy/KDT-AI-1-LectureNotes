package kr.eddi.demo.lectureClass.websocket.service;

import kr.eddi.demo.lectureClass.websocket.entity.Message;

import java.util.List;

public interface WebSocketMessageService {

    List<Message> getMessages(String room);
    Message saveMessage(Message message);
}