package board.controller.form;

import board.entity.JpaBoard;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;


// 외부에서 전달받을 데이터의 form을 설정합니다.
// @RequiredArgsConstructor 어노테이션을 사용하면 별도의 생성자를 정의하지 않아도 됩니다.
@Getter
@ToString
@RequiredArgsConstructor
public class RequestBoardForm {
    final private String title;
    final private String content;
    final private String writer;

    // toJpaBoard()라는 매서드를 정의합니다.
    // title, writer, content 3개의 값을 받아 새로운 JpaBoard 생성하여 반환합니다.
    public JpaBoard toJpaBoard() {
        return new JpaBoard(title, writer, content);
    }
}
