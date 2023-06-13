package com.example.demo.practice.board.controller.form;

import com.example.demo.practice.board.entity.BoardEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor
public class BoardForm {

    private String title;
    private String content;
    private String writer;

    public BoardEntity toBoard() {
        // Board Entity에서 생성자를 만들어 줬어야 함

        return new BoardEntity(title, content, writer);
    }
}
