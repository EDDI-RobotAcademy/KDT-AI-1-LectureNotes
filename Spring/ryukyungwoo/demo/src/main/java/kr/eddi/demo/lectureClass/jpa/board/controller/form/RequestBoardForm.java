package kr.eddi.demo.lectureClass.jpa.board.controller.form;

import kr.eddi.demo.lectureClass.jpa.board.entity.JpaBoard;
import lombok.*;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RequestBoardForm {
    private String title;
    private String content;
    private String writer;

    public JpaBoard toJpaBoard() {
        return new JpaBoard(title, writer, content);
    }
}
