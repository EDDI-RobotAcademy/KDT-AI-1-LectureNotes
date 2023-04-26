package com.example.demo.lectureClass.jpa.board.service;

import com.example.demo.lectureClass.jpa.board.controller.form.RequestBoardForm;
import com.example.demo.lectureClass.jpa.board.entity.JpaBoard;
import com.example.demo.lectureClass.jpa.board.refository.JpaBoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class JpaBoardServiceImpl implements JpaBoardService {
    // RequiredArgsConstructor 통해 boardRepository 자동으로 제어
    final private JpaBoardRepository boardRepository;

    @Override
    public List<JpaBoard> list() {
        // boardId에 맞춰서 Sort 정렬 정렬해줄때 DESC 내림차순으로 한다.
        return boardRepository.findAll(Sort.by(Sort.Direction.DESC, "boardId"));
    }

    @Override
    public JpaBoard register(JpaBoard jpaBoard) {
        return boardRepository.save(jpaBoard);
    }

    @Override
    // boardId를 가지고 엔티티를 찾는다.
    // findById를 하면 아이디에 해당하는 엔티티를 찾는다. (JpaBoard에 Id를 말함)
    public JpaBoard read(Long boardId) {
        // Optional은 자바에서 제공하는 get을 할때 값을 얻을 수 있고, 없으면 null이다.
        Optional<JpaBoard> maybeJpaBoard = boardRepository.findById(boardId); // boardId가 들어간다.

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
