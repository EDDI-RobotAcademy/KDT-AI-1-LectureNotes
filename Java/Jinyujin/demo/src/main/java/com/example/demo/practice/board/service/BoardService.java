package com.example.demo.practice.board.service;

import com.example.demo.practice.board.controller.form.BoardForm;
import com.example.demo.practice.board.entity.BoardEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BoardService {

    List<BoardEntity> boardList();

    BoardEntity boardRegister(BoardEntity boardEntity);

    BoardEntity boardRead(Long boardId);

    void boardDelete(Long boardId);

    BoardEntity boardModify(Long boardId, BoardForm boardForm);
}

