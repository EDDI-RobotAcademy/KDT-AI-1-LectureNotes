package kr.eddi.demo.jpa.board.service;

import kr.eddi.demo.jpa.board.controller.form.RequestBoardForm;
import kr.eddi.demo.jpa.board.entity.JpaBoard;

import java.util.List;


public interface JpaBoardService {
    // 사용할 매서드들
    List<JpaBoard> list();

    JpaBoard register(JpaBoard jpaBoard);

    JpaBoard read(Long boardId);

    void delete(Long boardId);

    JpaBoard modify(Long boardId, RequestBoardForm requestBoardForm);
}