package com.example.demo.lectureClass.webSocket.Controller;

import com.example.demo.lectureClass.webSocket.entity.Message;
import com.example.demo.lectureClass.webSocket.service.WebSocketMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/message")
public class WebSocketController {

    final private WebSocketMessageService messageService;

    @GetMapping("/{room}")
    public List<Message> getMessage(@PathVariable String room) {
        return messageService.getMessages(room);
    }
}
