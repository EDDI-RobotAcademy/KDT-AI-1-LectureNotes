package kr.eddi.demo.lectureClass.websocket.socket;

import com.corundumstudio.socketio.SocketIOClient;
import kr.eddi.demo.lectureClass.websocket.entity.Message;
import kr.eddi.demo.lectureClass.websocket.entity.MessageType;
import kr.eddi.demo.lectureClass.websocket.service.WebSocketMessageService;
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

    public void saveMessage(SocketIOClient senderClient, Message message) {
        Message storedMessage = messageService.saveMessage(Message.builder()
                .messageType(MessageType.SERVER)
                .content(message.getContent())
                .room(message.getRoom())
                .username(message.getUsername())
                .build());

        sendSocketMessage(senderClient, storedMessage, message.getRoom());
    }

    public void saveInfoMessage(SocketIOClient senderClient, String message, String room) {
        Message storedMessage = messageService.saveMessage(Message.builder()
                .messageType(MessageType.SERVER)
                .content(message)
                .room(room)
                .build());

        sendSocketMessage(senderClient, storedMessage, room);
    }
}