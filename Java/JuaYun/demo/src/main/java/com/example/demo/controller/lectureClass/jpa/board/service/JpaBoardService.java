package com.example.demo.controller.lectureClass.jpa.board.service;

import com.example.demo.controller.lectureClass.jpa.board.conrtoller.form.RequestBoardForm;
import com.example.demo.controller.lectureClass.jpa.board.entity.JpaBoard;

import java.util.List;

public interface JpaBoardService {
    List<JpaBoard> list();

    JpaBoard register(JpaBoard jpaBoard);

    JpaBoard read(Long boardId);

    void delete(Long boardId);

    JpaBoard modify(Long boardId, RequestBoardForm requestBoardForm);
}
