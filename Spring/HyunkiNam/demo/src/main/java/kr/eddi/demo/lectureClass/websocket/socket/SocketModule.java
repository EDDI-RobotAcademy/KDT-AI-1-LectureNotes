package kr.eddi.demo.lectureClass.websocket.socket;

import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DataListener;
import com.corundumstudio.socketio.listener.DisconnectListener;
import kr.eddi.demo.lectureClass.websocket.constants.Constants;
import kr.eddi.demo.lectureClass.websocket.entity.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Slf4j
@Component
public class SocketModule {

    private final SocketIOServer server;
    private final SocketService socketService;

    public SocketModule(SocketIOServer server, SocketService socketService) {
        this.server = server;
        this.socketService = socketService;

        server.addConnectListener(onConnected());
        server.addDisconnectListener(onDisconnected());
        server.addEventListener("send_message", Message.class, onChatReceived());
    }

    private DataListener<Message> onChatReceived () {
        return (senderClient, data, ackSender) -> {
            log.info(data.toString());
            socketService.saveMessage(senderClient, data);
        };
    }

    private ConnectListener onConnected () {
        return (client) -> {
            var params = client.getHandshakeData().getUrlParams();
            String room = params.get("room").stream().collect(Collectors.joining());
            String username = params.get("username").stream().collect(Collectors.joining());
            client.joinRoom(room);
            socketService.saveInfoMessage(client, String.format(Constants.WELCOME, username), room);
            log.info("session[{}] - id[{}] - room[{}]", client.getSessionId().toString(), room, username);
        };
    }

    private DisconnectListener onDisconnected () {
        return client -> {
            var params = client.getHandshakeData().getUrlParams();
            String room = params.get("room").stream().collect(Collectors.joining());
            String username = params.get("username").stream().collect(Collectors.joining());

            socketService.saveInfoMessage(client, String.format(Constants.DISCONNECT, username), room);
            log.info("session[{}] - id[{}] - room[{}]", client.getSessionId().toString(), room, username);
        };
    }
}