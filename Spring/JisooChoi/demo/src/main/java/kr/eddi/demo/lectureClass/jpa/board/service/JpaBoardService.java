package kr.eddi.demo.lectureClass.jpa.board.service;

import kr.eddi.demo.lectureClass.jpa.board.controller.form.RequestBoardForm;
import kr.eddi.demo.lectureClass.jpa.board.entity.JpaBoard;

import java.util.List;

public interface JpaBoardService {
    // 게시판에서 서비스 되는 모든 기능들 ?

    List<JpaBoard> list(); // 게시글

    // 등록
    JpaBoard register(JpaBoard jpaBoard);

    // 조회
    JpaBoard read(Long boardId);

    // 삭제
    void delete(Long boardId);

    // 수정
    JpaBoard modify(Long boardId, RequestBoardForm requestBoardForm);
}
