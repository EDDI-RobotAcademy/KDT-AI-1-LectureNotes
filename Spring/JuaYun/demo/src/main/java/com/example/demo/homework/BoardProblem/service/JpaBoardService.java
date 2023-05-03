package com.example.demo.homework.BoardProblem.service;

import com.example.demo.homework.BoardProblem.controller.form.RequestBoardForm;
import com.example.demo.homework.BoardProblem.entity.JpaBoard;

import java.util.List;

public interface JpaBoardService {
    // 여기서 설정을 해줘야 controller 에서 오류가 발생하지 않음

    // 게시물 목록
    List<JpaBoard> list();
    // 게시물 등록
    JpaBoard register(JpaBoard jpaBoard);
    // 게시물 읽기
    JpaBoard read(Long boardId);

    // 게시물 삭제
    void delete(Long boardId);

    // 게시물 수정
    JpaBoard modify(Long boardId, RequestBoardForm requestBoardForm);
}
