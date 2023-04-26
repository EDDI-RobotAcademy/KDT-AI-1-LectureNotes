package kr.eddi.demo.lectureClass.jpa.board.controller.form;

import kr.eddi.demo.lectureClass.jpa.board.entity.JpaBoard;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
// 전달 받을 데이터 Form
public class RequestBoardForm {
    final private String title;
    final private String content;
    final private String writer;
    
    // 전달 받은 값들을 가지고 JpaBoard 형식 만들어주기
    public JpaBoard toJpaBoard() {
        return new JpaBoard(title, writer, content);
    }
}