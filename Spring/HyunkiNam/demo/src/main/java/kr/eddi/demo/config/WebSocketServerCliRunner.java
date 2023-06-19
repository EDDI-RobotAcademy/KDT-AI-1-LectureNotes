package kr.eddi.demo.config;

import com.corundumstudio.socketio.SocketIOServer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class WebSocketServerCliRunner implements CommandLineRunner {

    final private SocketIOServer server;

    @Override
    public void run(String... args) throws Exception {
        server.start();
    }
}