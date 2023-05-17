package com.example.demo.homework.BoardProblem.controller.form;

import com.example.demo.homework.BoardProblem.entity.JpaBoard;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class RequestBoardForm {
    // 요청 데이터를 담는 클래스
    // 제목 내용 작성자 정보를 담고 있음
    final private String title;
    final private String content;
    final private String writer;

    // toJpaBoard() 메소드를 통해ㅔ RequestBoardForm 객체를
    // JpaBoard 객체로 변환했음
    public JpaBoard toJpaBoard() {
        return new JpaBoard(title, writer, content);
    }
}
