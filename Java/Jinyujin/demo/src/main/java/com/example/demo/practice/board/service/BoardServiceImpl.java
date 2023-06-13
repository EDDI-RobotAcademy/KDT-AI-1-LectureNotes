package com.example.demo.practice.board.service;

import com.example.demo.practice.board.controller.BoardController;
import com.example.demo.practice.board.controller.form.BoardForm;
import com.example.demo.practice.board.entity.BoardEntity;
import com.example.demo.practice.board.repository.BoardRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoardServiceImpl implements BoardService {

    BoardRepository boardRepository;

    @Override
    public List<BoardEntity> boardList() {
        return boardRepository.findAll(Sort.by(Sort.Direction.DESC,"productId"));
    }

    @Override
    public BoardEntity boardRegister(BoardEntity boardEntity) {
        return boardRepository.save(boardEntity);
    }

    @Override
    public BoardEntity boardRead(Long boardId) {

        Optional<BoardEntity> maybeBoard = boardRepository.findById(boardId);

        if (maybeBoard.isEmpty()) {
            return null;
        }

        return maybeBoard.get();
    }

    @Override
    public void boardDelete(Long boardId) {
        boardRepository.deleteById(boardId);
    }

    @Override
    public BoardEntity boardModify(Long boardId, BoardForm boardForm) {
        Optional<BoardEntity> maybeBoard = boardRepository.findById(boardId);

        if (maybeBoard.isEmpty()) {
            return null;
        }

        maybeBoard.get().setTitle(boardForm.getTitle());
        maybeBoard.get().setContent(boardForm.getContent());
        // 수정하도록 바꾼 코드

        return boardRepository.save(maybeBoard.get());
    }
}
