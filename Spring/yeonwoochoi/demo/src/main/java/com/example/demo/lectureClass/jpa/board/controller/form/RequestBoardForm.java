package com.example.demo.lectureClass.jpa.board.controller.form;

import com.example.demo.lectureClass.jpa.board.entity.JpaBoard;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class RequestBoardForm {
    // 이런 상황(수정)에서 content를 빼고 사용하는게 좋다.
    // 네트워크를 타고 나가는게 2개보다 3개가 돈이 더 많이 들기 때문에
    final private String title;
    final private String content;
    final private String writer;

    public JpaBoard toJpaBoard() {
        return new JpaBoard(title, writer, content);
    }
}