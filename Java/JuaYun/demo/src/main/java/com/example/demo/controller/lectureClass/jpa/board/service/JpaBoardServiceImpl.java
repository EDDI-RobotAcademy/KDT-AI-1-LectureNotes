package com.example.demo.controller.lectureClass.jpa.board.service;

import com.example.demo.controller.lectureClass.jpa.board.conrtoller.form.RequestBoardForm;
import com.example.demo.controller.lectureClass.jpa.board.entity.JpaBoard;
import com.example.demo.controller.lectureClass.jpa.board.repository.JpaBoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class JpaBoardServiceImpl implements JpaBoardService{

    final private JpaBoardRepository boardRepository;

    @Override
    public List<JpaBoard> list() {
        return boardRepository.findAll(Sort.by(Sort.Direction.DESC, "boardId"));
    }

    @Override
    public JpaBoard register(JpaBoard jpaBoard) {
        return boardRepository.save(jpaBoard);
    }

    @Override
    public JpaBoard read(Long boardId) {
        Optional<JpaBoard> maybeJpaBoard = boardRepository.findById(boardId);

        if (maybeJpaBoard.isEmpty()) {
            log.info("정보가 없습니다!");
            return null;
        }

        return maybeJpaBoard.get();
    }

    @Override
    public void delete(Long boardId) {
        boardRepository.deleteById(boardId);
    }

    @Override
    public JpaBoard modify(Long boardId, RequestBoardForm requestBoardForm) {
        Optional<JpaBoard> maybeJpaBoard = boardRepository.findById(boardId);

        if (maybeJpaBoard.isEmpty()) {
            log.info("정보가 없습니다!");
            return null;
        }

        JpaBoard board = maybeJpaBoard.get();
        board.setTitle(requestBoardForm.getTitle());
        board.setContent(requestBoardForm.getContent());

        return boardRepository.save(board);
    }
}
