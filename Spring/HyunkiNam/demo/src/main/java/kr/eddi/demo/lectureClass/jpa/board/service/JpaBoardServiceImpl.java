package kr.eddi.demo.lectureClass.jpa.board.service;

import kr.eddi.demo.lectureClass.jpa.board.controller.form.RequestBoardForm;
import kr.eddi.demo.lectureClass.jpa.board.entity.JpaBoard;
import kr.eddi.demo.lectureClass.jpa.board.repository.JpaBoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
// Service에 선언된 메서드들 구체화?
public class JpaBoardServiceImpl implements JpaBoardService {

    // 저장소 작동? 위해 boardRepositry 선언
    final private JpaBoardRepository boardRepository;

    @Override
    // 저장소 내 전체 값 가져오기 ( boardId 기준으로 내림차순 정렬 )
    public List<JpaBoard> list() {
        return boardRepository.findAll(Sort.by(Sort.Direction.DESC, "boardId"));
    }

    // 받은 jpaBoard값 저장소에 저장
    @Override
    public JpaBoard register(JpaBoard jpaBoard) {
        return boardRepository.save(jpaBoard);
    }

    // 받은 boardId로 저장소 내의 데이터 검색
    // 값이 없다면 null 리턴
    // 있다면 찾은 값 리턴
    @Override
    public JpaBoard read(Long boardId) {
        Optional<JpaBoard> maybeJpaBoard = boardRepository.findById(boardId);

        if (maybeJpaBoard.isEmpty()) {
            log.info("정보가 없습니다!");
            return null;
        }

        return maybeJpaBoard.get();
    }

    // 받은 boardId로 저장소 내의 데이터 검색
    // 값이 없다면 null 리턴
    // 있다면 찾은 값 삭제
    @Override
    public void delete(Long boardId) {
        boardRepository.deleteById(boardId);
    }

    // 받은 boardId로 저장소 내의 데이터 검색
    // 값이 없다면 null 리턴
    // 있다면 찾은 값에서 Title과 Content 값 Update함
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
