package kr.eddi.demo.lectureClass.websocket.repository;

import kr.eddi.demo.lectureClass.websocket.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WebSocketMessageRepository extends JpaRepository<Message, Long> {

    List<Message> findAllByRoom(String room);
}