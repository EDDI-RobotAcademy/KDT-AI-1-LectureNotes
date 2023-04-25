package com.example.demo.controller.lectureClass.jpa.board.conrtoller;

import com.example.demo.controller.lectureClass.jpa.board.entity.JpaBoard;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/jpa-board")
public class JpaBoardController {

    final private JpaBoardService boardService;

    @GetMapping("/list")
    public List<JpaBoard> boardList () {
        log.info("boardList");

        return boardService.list();
    }
}
