package com.example.demo.config;

import com.corundumstudio.socketio.SocketIOServer;
import jakarta.persistence.Basic;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebSocketIOConfig {

    private String host = "localhost";
    private Integer port = 9999;

    @Bean
    public SocketIOServer socketIOServer(){
        com.corundumstudio.socketio.Configuration config =
                new com.corundumstudio.socketio.Configuration();
        config.setHostname(host);
        config.setPort(port);

        return new SocketIOServer(config);
    }
}
