package kr.eddi.demo.lectureClass.websocket.service;

import kr.eddi.demo.lectureClass.websocket.entity.Message;
import kr.eddi.demo.lectureClass.websocket.repository.WebSocketMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WebSocketMessageServiceImpl implements WebSocketMessageService {

    final private WebSocketMessageRepository MessageRepository;
    @Override
    public List<Message> getMessages(String room) {
        return MessageRepository.findAllByRoom(room);
    }

    @Override
    public Message saveMessage(Message message) {
        return MessageRepository.save(message);
    }
}
