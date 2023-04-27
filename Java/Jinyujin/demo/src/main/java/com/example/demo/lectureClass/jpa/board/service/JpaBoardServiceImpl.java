package com.example.demo.lectureClass.jpa.board.service;

import com.example.demo.lectureClass.jpa.board.controller.form.RequestBoardForm;
import com.example.demo.lectureClass.jpa.board.entity.JpaBoard;
import com.example.demo.lectureClass.jpa.board.repository.JpaBoardRepository;
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

    final private JpaBoardRepository boardRepository;

    @Override
    public List<JpaBoard> list() {
        return boardRepository.findAll(Sort.by(Sort.Direction.DESC, "boardId"));
    }
    // list() 구현
    // boardId를 다 찾아서 내림차순으로 정렬해라

    @Override
    public JpaBoard register(JpaBoard jpaBoard) {
        return boardRepository.save(jpaBoard);
    }

    @Override
    public JpaBoard read(Long boardId) {
        Optional<JpaBoard> maybeJpaBoard = boardRepository.findById(boardId);
        // findById: 엔티티의 아이디에 해당하는 것을 찾음
        // 고유값을 기반으로 정보를 검색해 주세요
        // 즉 JpaBoard에 선언되어 있는 boardId를 찾는 것 - 그래서 boardId는 꼭 유니크해야 함
        // 같은 상품이라고 하더라도 제조사나 가격이 다르다고 하면 아이디 값이 달라야 한다

        // findById -> 아이디 값이 있을 수도 있고 없을 수도 있음
        // 그것을 간단하게 처리해줄 수 있는 것이 Optional

        if (maybeJpaBoard.isEmpty()) {
            log.info("정보가 없습니다!");
            return null;
        }

        return maybeJpaBoard.get();
        // 값이 있으면 get을 return하고 없으면 null을 return하도록
    }

    @Override
    public void delete(Long boardId) {
        boardRepository.deleteById(boardId);
    }

    @Override
    public JpaBoard modify(Long boardId, RequestBoardForm requestBoardForm) {
        // 여기는 read 부분 가져와서 쓸 수 있음
        Optional<JpaBoard> maybeJpaBoard = boardRepository.findById(boardId);
        // Optional: null일 수도 있는 객체를 감싸는 일종의 Wrapper 클래스
        // https://velog.io/@wldus9503/spring-boot-OptionalT
        // null일 수도 있는 객체를 다룰 수 있도록 도움
        // findById는 repository 때문에 사용 가능한 것

        if (maybeJpaBoard.isEmpty()) {
            log.info("정보가 없습니다!");
            return null;
        }
        // 여기까지 똑같음
        // 수정은 조금 더 추가

        JpaBoard board = maybeJpaBoard.get();
        // get(): Optional 내부에 담긴 객체를 반환
        board.setTitle(requestBoardForm.getTitle());
        // 객체를 생성하지 않고 setter를 사용하는 이유
        // 고유값이 바뀌어버리니까
        board.setContent(requestBoardForm.getContent());

        return boardRepository.save(board);
        // save, deleteById 등 이런것들은 다 repository 때문에 사용 가능한 것

    }
}
