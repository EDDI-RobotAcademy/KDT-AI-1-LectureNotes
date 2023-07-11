package board.service;


import board.controller.form.RequestBoardForm;
import board.entity.JpaBoard;

import java.util.List;

// JpaBoardService 인터페이스를 생성합니다.
// 이 인터페이스를 상속받아 사용하는 클래스는 5가지의 매서드를 반드시 사용하게 됩니다.
public interface JpaBoardService {
    List<JpaBoard> list();

    JpaBoard register(JpaBoard jpaBoard);

    JpaBoard read(Long boardId);

    void delete(Long boardId);

    JpaBoard modify(Long boardId, RequestBoardForm requestBoardForm);
}