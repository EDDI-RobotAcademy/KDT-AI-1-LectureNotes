package com.example.demo.lectureClass.websocket.service;

import com.example.demo.lectureClass.websocket.entity.Message;
import com.example.demo.lectureClass.websocket.repository.WebSocketMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WebSocketMessageServiceImpl implements WebSocketMessageService{

    final private WebSocketMessageRepository messageRepository;

    @Override
    public List<Message> getMessages(String room) {

        return messageRepository.findAllByRoom(room);
    }
    // getMassages 메서드에서는 저장되어 있는 모든 방을 찾아
    // 메세지 타입의 리스트로 반환하도록 함

    @Override
    public Message saveMessage(Message message) {

        return messageRepository.save(message);
    }
    // saveMessage 메서드에서는 메세지를 저장하도록 함
}
