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
// implements
// 부모 객체는 선언만 하며, 정의(내용)는 자식에서 오버라이딩(재정의) 해서 사용해야한다.
// 또한 implements는 다중상속을 대신해준다.
public class JpaBoardServiceImpl implements JpaBoardService {
    // RequiredArgsConstructor 통해 boardRepository 자동으로 제어
    final private JpaBoardRepository boardRepository;

    @Override
    public List<JpaBoard> list() {
        // boardId에 맞춰서 Sort 정렬, 정렬해줄때 DESC 내림차순으로 한다.
        return boardRepository.findAll(Sort.by(Sort.Direction.DESC, "boardId"));
    }

    @Override
    public JpaBoard register(JpaBoard jpaBoard) {
        // jpaBoard 내림차순으로 boardRepository 저장 (등록)
        return boardRepository.save(jpaBoard);
    }

    // findAll을 하면 해당 테이블에 있는 모든걸 가져와야 하고,
    // findById는 한건에 대한 데이터

    @Override
    // boardId를 가지고 엔티티를 찾는다.
    // findById를 하면 아이디에 해당하는 엔티티를 찾는다. (JpaBoard에 Id를 말함)
    public JpaBoard read(Long boardId) {
        // Optional은 자바에서 제공하는 get을 할때 값을 얻을 수 있고, 없으면 null이다.
        // 등록한 boardRepository 게시물 하나를 읽어온다.
        Optional<JpaBoard> maybeJpaBoard = boardRepository.findById(boardId); // boardId가 들어간다.

        // isEmpty() 메소드는 문자열이 빈 값이면 true, 비어있지 않으면 false를 리턴
        if (maybeJpaBoard.isEmpty()) {
            log.info("정보가 없습니다!");
            return null;
        }
        // 있다면 maybeJpaBoard 정보를 가져온다.
        return maybeJpaBoard.get();
    }

    @Override
    public void delete(Long boardId) {
        // 전달 된 하나의(deleteById) ID를 삭제
        boardRepository.deleteById(boardId);
    }

    // Optional 맞을수도 있고, 아닐수도 있다.
    // modify 먼저 읽어온다. (읽기랑 비슷함)
    @Override
    public JpaBoard modify(Long boardId, RequestBoardForm requestBoardForm) {
        // 등록되어 있는 게시물 boardId
        Optional<JpaBoard> maybeJpaBoard = boardRepository.findById(boardId);

        // isEmpty() 메소드는 문자열이 빈 값이면 true, 비어있지 않으면 false를 리턴
        if (maybeJpaBoard.isEmpty()) {
            log.info("정보가 없습니다!");
            // 없으면 null
            return null;
        }

        // setTitle 생성자를 호출하게 되면 고유값이 바뀐다. (boardId -> 바뀌면 안되는 고유 값)
        JpaBoard board = maybeJpaBoard.get();
        board.setTitle(requestBoardForm.getTitle());
        board.setContent(requestBoardForm.getContent());

        // 수정한 작업을 저장하고, 갱신 한다.
        return boardRepository.save(board);
    }
}
