package com.example.demo.controller.lectureClass.jpa.board.conrtoller.form;

import com.example.demo.controller.lectureClass.jpa.board.entity.JpaBoard;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RequestBoardForm {
    final private String title;
    final private String content;
    final private String writer;

    public JpaBoard toJpaBoard() {
        return new JpaBoard(title, writer, content);
    }
}
