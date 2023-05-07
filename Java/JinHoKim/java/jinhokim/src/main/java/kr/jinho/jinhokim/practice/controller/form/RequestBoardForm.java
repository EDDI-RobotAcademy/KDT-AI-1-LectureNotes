package kr.jinho.jinhokim.practice.controller.form;

import kr.jinho.jinhokim.practice.entity.JpaBoard;
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

    public JpaBoard toJpaBoard() {
        return new JpaBoard(title, writer, content);
    }
}
