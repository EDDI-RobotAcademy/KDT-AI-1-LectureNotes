package com.example.demo.practice.board.controller;

import com.example.demo.practice.board.controller.form.BoardForm;
import com.example.demo.practice.board.entity.BoardEntity;
import com.example.demo.practice.board.service.BoardService;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/board")
public class BoardController {

    private BoardService boardService;

    @GetMapping("/list")
    public List<BoardEntity> boardList() {
        return boardService.boardList();
    }

    @PostMapping("/register")
    public BoardEntity boardRegister(@RequestBody BoardForm boardForm) {

        return boardService.boardRegister(boardForm.toBoard());
    }

    @GetMapping("/{boardId}")
    public BoardEntity boardRead(@PathVariable Long boardId) {

    return boardService.boardRead(boardId);
    }

    @DeleteMapping("/{boardId}")
    public void boardDelete(@PathVariable Long boardId) {
        boardService.boardDelete(boardId);
    }

    @PutMapping("/{boardId}")
    public BoardEntity boardModify(@PathVariable Long boardId, @RequestBody BoardForm boardForm) {

        return boardService.boardModify(boardId, boardForm);
    }
}
