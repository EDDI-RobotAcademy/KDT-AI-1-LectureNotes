package com.example.demo.lectureClass.jpa.board.controller.form;

import com.example.demo.lectureClass.jpa.board.entity.JpaBoard;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
@RequiredArgsConstructor
public class RequestBoardForm {
    final private String title;
    final private String content;
    final private String writer;

    public JpaBoard toJpaBoard() {
        return new JpaBoard(title, writer, content);
    }
}
