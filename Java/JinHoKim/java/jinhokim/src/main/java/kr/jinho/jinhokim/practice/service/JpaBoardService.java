package kr.jinho.jinhokim.practice.service;

import kr.jinho.jinhokim.practice.controller.form.RequestBoardForm;
import kr.jinho.jinhokim.practice.entity.JpaBoard;

import java.util.List;

public interface JpaBoardService {
    List<JpaBoard> list();

    JpaBoard register(JpaBoard jpaBoard);

    JpaBoard read(Long boardId);

    void delete(Long boardId);

    JpaBoard modify(Long boardId, RequestBoardForm requestBoardForm);
}
