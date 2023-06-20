package com.example.demo.lectureClass.websocket.controller;

import com.example.demo.lectureClass.websocket.entity.Message;
import com.example.demo.lectureClass.websocket.service.WebSocketMessageService;
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
    /*
      room에서는 리스트로 메세지를 얻는다
      메세지 엔티티에는 메세지 타입, 방, 내용, 작성자가 있음
    */
}
