package kr.eddi.demo.jpa.board.service;


import kr.eddi.demo.jpa.board.controller.form.RequestBoardForm;
import kr.eddi.demo.jpa.board.entity.JpaBoard;
import kr.eddi.demo.jpa.board.repository.JpaBoardRepository;
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
    //서비스의 기술된 것들을 자세히 메서드와 함

    final private JpaBoardRepository boardRepository;
    //데이터 베이승의 값을 가져오가나 변경하기 boardRepository 생성

    @Override
    public List<JpaBoard> list() {

        return boardRepository.findAll(Sort.by(Sort.Direction.DESC, "boardId"));
    }
    //boardId를 기준으로 내림차순 정렬한 보드 리스트를 리턴해줌

    @Override
    public JpaBoard register(JpaBoard jpaBoard) {
        return boardRepository.save(jpaBoard);
    }
    //jpq보드에 받은 데이터를 저장해줍니다.

    @Override
    public JpaBoard read(Long boardId) {
        Optional<JpaBoard> maybeJpaBoard = boardRepository.findById(boardId);
        //boardRepository에서  받은 id값을 통해  보드를 찾는다.

        if (maybeJpaBoard.isEmpty()) {
            log.info("정보가 없습니다!");
            return null;
        }//없으면 return null

        return maybeJpaBoard.get();
        //있으면 그 보드를 겟 또
    }

    @Override
    public void delete(Long boardId) {
        boardRepository.deleteById(boardId);
    }
    //받은 id에 따라 해당 정보 삭제하는 매서드

    @Override
    public JpaBoard modify(Long boardId, RequestBoardForm requestBoardForm) {
        //보드 아이디와  수정 한 데이터 받아오기
        Optional<JpaBoard> maybeJpaBoard = boardRepository.findById(boardId);
        // 받은 아이디에 보드가 있니 있으면 그건 maybeJpaBoard다.
        if (maybeJpaBoard.isEmpty()) {
            log.info("정보가 없습니다!");
            return null;
        }
        // 데이터가 있으면 해당 데이터를 겟해와
        JpaBoard board = maybeJpaBoard.get();
        //겟해왔다면 그 해당 위치의 데이터를 뷰에서 넘어온 데이터 (requestBoardForm)로 셋해줌

        board.setTitle(requestBoardForm.getTitle());
        board.setContent(requestBoardForm.getContent());

        return boardRepository.save(board);
        //바꾼 데이터로 만들어진 보드를 다시 저장합니다.
    }

}