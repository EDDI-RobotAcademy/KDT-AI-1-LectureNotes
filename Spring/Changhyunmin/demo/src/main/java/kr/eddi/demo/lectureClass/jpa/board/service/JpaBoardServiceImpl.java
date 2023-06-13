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
public class JpaBoardServiceImpl implements JpaBoardService {
    //JpaBoardService 의 인터페이스를 갖고온다.
    final private JpaBoardRepository boardRepository;
    //boardID와 JpaBoard 값을 갖고있는 JpaBoardRepository 생성
    @Override
    public List<JpaBoard> list() {
        return boardRepository.findAll(Sort.by(Sort.Direction.DESC, "boardId"));
    }

    @Override
    public JpaBoard register(JpaBoard jpaBoard) {
        return boardRepository.save(jpaBoard);
    }
    //

    @Override
    public JpaBoard read(Long boardId) {
        Optional<JpaBoard> maybeJpaBoard = boardRepository.findById(boardId);
        //boardRepository 에서  받은 id 값을 통해  보드를 찾는다.

        if (maybeJpaBoard.isEmpty()) {
            log.info("정보가 없습니다!");
            return null;
        }
    //없으면 return null

        return maybeJpaBoard.get();
    //있으면 그 보드를 사용한다.
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
        //변경을 위해 setter 를 불러왔다(부분적으로).ㄱ
        board.setTitle(requestBoardForm.getTitle());
        board.setContent(requestBoardForm.getContent());
        //수정(변경)한 작업을 다시 저장해서 마무리하는 구조이다.
        return boardRepository.save(board);
    }
}