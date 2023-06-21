package com.example.demo.config;

import com.corundumstudio.socketio.SocketIOServer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class WebSocketServerCliRunner implements CommandLineRunner {
    /*
      CommandLineRunner: 스프링이 로드될 때 특정 코드를 실행할 수 있음
      CommandLineRunner를 구현한 구현체는 @Component를 통해 컴포넌트를 스캔할 수 있음
      그리고 스프링부트가 구동되는 시점에 run() 메서드 실행
      여기서는 서버가 시작되도록 함
    */

    final private SocketIOServer server;
    // SocketIOServer: 내장 라이브러리

    @Override
    public void run(String... args) throws Exception {
        // ... args는 스프링 부트 구동 시 실행 인자가 있다면 받아서 처리하게 함
        server.start();
        // 즉 스프링 부트 구동 시 Socket.IO서버가 시작되도록 하는 것
    }
}
