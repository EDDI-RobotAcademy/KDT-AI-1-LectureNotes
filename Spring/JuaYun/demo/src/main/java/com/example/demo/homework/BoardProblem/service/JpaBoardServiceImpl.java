package com.example.demo.homework.BoardProblem.service;

import com.example.demo.homework.BoardProblem.controller.form.RequestBoardForm;
import com.example.demo.homework.BoardProblem.entity.JpaBoard;
import com.example.demo.homework.BoardProblem.repository.JpaBoardRepository;
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
    // 게시판 기능을 구현한 것으로 생각된다.

    // CRUD 기능을 구현하기 위해 JpaBoardRepository 를 가져옴
    final private JpaBoardRepository boardRepository;

    @Override
    public List<JpaBoard> list() {
        // 게시글 목록을 조회하는 메소드: list()
        // Sort 를 이용하여 내림차순 정렬한 결과를 반허ㅣㄴ
        return boardRepository.findAll(Sort.by(Sort.Direction.DESC, "boardId"));
    }

    @Override
    // 새로운 게시글을 등록하는 메소드: register()
    // save() 메소드를 이용하여 JpaBoard 객체를 저장하고 반환한다.
    public JpaBoard register(JpaBoard jpaBoard) {
        return boardRepository.save(jpaBoard);
    }

    @Override
    // 특정 게시글을 조회하는 메소드: read()
    // findById() 메소드를 이용하여 boardId 에 해당하는 게시글을 조회
    // 조회 결과가 없을 경우 null 값을 반환
    public JpaBoard read(Long boardId) {
        Optional<JpaBoard> maybeJpaBoard = boardRepository.findById(boardId);

        if (maybeJpaBoard.isEmpty()) {
            log.info("정보가 없습니다!");
            return null;
        }

        return maybeJpaBoard.get();
    }

    @Override
    // 게시글 삭제
    public void delete(Long boardId) {
        boardRepository.deleteById(boardId);
    }

    @Override
    // 특정 게시글을 수정하는 메소드: modify()
    // findById() 메소드를 이용하여 boardId 에 해당하는 게시글을 조회
    public JpaBoard modify(Long boardId, RequestBoardForm requestBoardForm) {
        Optional<JpaBoard> maybeJpaBoard = boardRepository.findById(boardId);

        if (maybeJpaBoard.isEmpty()) {
            log.info("정보가 없습니다!");
            return null;
        }

        // RequestBoardForm 에서 @Getter 해서 가져왔음
        // 해당 게시글이 존재할 경우 RequestBoardForm 객체에서 받아온 데이터로
        // 게시글의 제목과 내용을 수정한 후 저장
        JpaBoard board = maybeJpaBoard.get();
        board.setTitle(requestBoardForm.getTitle());
        board.setContent(requestBoardForm.getContent());

        return boardRepository.save(board);
    }
}
