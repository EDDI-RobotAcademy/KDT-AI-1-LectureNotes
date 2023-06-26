package com.example.demo.lectureClass.webSocket.socket;

import com.corundumstudio.socketio.SocketIOClient;
import com.example.demo.lectureClass.webSocket.entity.Message;
import com.example.demo.lectureClass.webSocket.entity.MessageType;
import com.example.demo.lectureClass.webSocket.service.WebSocketMessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SocketService {

    private final WebSocketMessageService messageService;

    public void sendSocketMessage(SocketIOClient senderClient, Message message, String room) {
        for (SocketIOClient client: senderClient.getNamespace().getRoomOperations(room).getClients()) {
            if (!client.getSessionId().equals(senderClient.getSessionId())) {
                client.sendEvent("read_message", message);
            }
        }
    }
    // builder 패턴이란 하나씩정하겠다...
    // 새로 메세지를 만들껀데 한번에 넣는게 아니라 messageType에 넣고, content에 넣고 룸에 넣겠다.
    // 만든메세지를 보냄.
    public void saveMessage(SocketIOClient senderClient, Message message) {
        Message storedMessage = messageService.saveMessage(Message.builder()
                .messageType(MessageType.SERVER)
                .content(message.getContent())
                .room(message.getRoom())
                .username(message.getUsername())
                .build());

        sendSocketMessage(senderClient, storedMessage, message.getRoom());
    }
    // 초기에 ~~환영합니다 ~~나갔습니다 보내는거
    // username이 없다 => 서버니까
    // 서버가 보내는 메세지
    public void saveInfoMessage(SocketIOClient senderClient, String message, String room) {
        Message storedMessage = messageService.saveMessage(Message.builder()
                .messageType(MessageType.SERVER)
                .content(message)
                .room(room)
                .build());

        sendSocketMessage(senderClient, storedMessage, room);
    }
}
