package com.example.demo.lectureClass.websocket.repository;

import com.example.demo.lectureClass.websocket.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WebSocketMessageRepository extends JpaRepository<Message, Long> {

    List<Message> findAllByRoom(String room);
}
