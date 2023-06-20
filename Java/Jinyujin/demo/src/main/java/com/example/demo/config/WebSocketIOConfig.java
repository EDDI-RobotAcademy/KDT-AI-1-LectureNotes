package com.example.demo.config;

import com.corundumstudio.socketio.SocketIOServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebSocketIOConfig {

    private String host = "localhost";
    private Integer port = 9999;

    @Bean
    public SocketIOServer socketIOServer () {
        com.corundumstudio.socketio.Configuration config =
                new com.corundumstudio.socketio.Configuration();
        /*
          com.corundumstudio.socketio.Configuration:
          Socket.IO server를 구성할 수 있도록 하는 라이브러리
        */

        config.setHostname(host); // 호스트 이름을 localhost로
        config.setPort(port); // 포트 번호를 9999로 설정

        return new SocketIOServer(config);
        /*
          이 config를 통해 host 이름을 localhost로 설정한,
          포트 번호를 9999로 설정한 SocketIO 서버를 구성
         */
    }
}
