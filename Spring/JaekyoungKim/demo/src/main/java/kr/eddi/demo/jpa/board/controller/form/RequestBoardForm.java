package kr.eddi.demo.jpa.board.controller.form;

import kr.eddi.demo.jpa.board.entity.JpaBoard;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;


@Getter
@ToString
@RequiredArgsConstructor
public class RequestBoardForm {
    final private String title;
    final private String content;
    final private String writer;
    // 받을 데이터 폼을 정함

    public JpaBoard toJpaBoard() {
        return new JpaBoard(title, writer, content);
    }
    // 뉴 보드 생성합니다.
}