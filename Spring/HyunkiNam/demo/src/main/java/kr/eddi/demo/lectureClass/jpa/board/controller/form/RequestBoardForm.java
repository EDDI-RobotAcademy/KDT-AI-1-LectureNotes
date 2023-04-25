package kr.eddi.demo.lectureClass.jpa.board.controller.form;

import kr.eddi.demo.lectureClass.jpa.board.entity.JpaBoard;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@ToString
@RequiredArgsConstructor
public class RequestBoardForm {
    private String title;
    private String writer;
    private String content;

    public JpaBoard toJpaBoard() {
        return new JpaBoard(title, writer, content);
    }
}
