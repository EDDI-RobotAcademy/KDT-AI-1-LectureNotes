package kr.jinho.jinhokim.practice.service;

import kr.jinho.jinhokim.practice.controller.form.RequestBoardForm;
import kr.jinho.jinhokim.practice.entity.JpaBoard;
import kr.jinho.jinhokim.practice.repository.JpaBoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JpaBoardServiceImpl implements JpaBoardService{

    final private JpaBoardRepository boardRepository;

    @Override
    public List<JpaBoard> list() {
        return boardRepository.findAll(Sort.by(Sort.Direction.DESC,"boardId"));
    }

    @Override
    public JpaBoard register(JpaBoard jpaBoard) {
        return boardRepository.save(jpaBoard);
    }

    @Override
    public JpaBoard read(Long boardId) {
        Optional<JpaBoard> maybeJpaBoard = boardRepository.findById(boardId);
        if (maybeJpaBoard.isEmpty()) {
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
            return null;
        }

        JpaBoard board = maybeJpaBoard.get();
        board.setTitle(requestBoardForm.getTitle());
        board.setContent(requestBoardForm.getContent());
        return boardRepository.save(board);
    }
}
