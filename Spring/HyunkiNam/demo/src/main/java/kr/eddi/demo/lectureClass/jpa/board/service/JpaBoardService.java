package kr.eddi.demo.lectureClass.jpa.board.service;

import kr.eddi.demo.lectureClass.jpa.board.controller.form.RequestBoardForm;
import kr.eddi.demo.lectureClass.jpa.board.entity.JpaBoard;

import java.util.List;

public interface JpaBoardService {

    List<JpaBoard> list();
    JpaBoard register(JpaBoard jpaBoard);
}
