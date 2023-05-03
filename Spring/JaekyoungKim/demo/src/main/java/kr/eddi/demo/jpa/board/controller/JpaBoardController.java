package kr.eddi.demo.jpa.board.controller;

import kr.eddi.demo.jpa.board.controller.form.RequestBoardForm;
import kr.eddi.demo.jpa.board.entity.JpaBoard;
import kr.eddi.demo.jpa.board.service.JpaBoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
//현재는 로그를 찍기 위해 사용
@RestController
@RequiredArgsConstructor
//생성자 만들지 않아도 사용하도록 사용
@RequestMapping("/jpa-board")
public class JpaBoardController {

    final private JpaBoardService boardService;
    //서비스 가져옵니다.

    @GetMapping("/list")
    public List<JpaBoard> boardList () {
        log.info("boardList()");

        List<JpaBoard> returnedBoardList = boardService.list();
        //보드 서비스의 리스트 메서드를 통해 리턴 받은 리스트를 뷰로 보내줌
        log.info("returnedBoardList: " + returnedBoardList);

        return returnedBoardList;
    }

    @PostMapping("/register")
    public JpaBoard registerBoard (@RequestBody RequestBoardForm requestBoardForm) {
        log.info("registerBoard()");
        //받은 데이터를 toJpaBoard해서 새로 만든 보드를 서비스의 레지스터를 통해 등록해줍니다.
        return boardService.register(requestBoardForm.toJpaBoard());
    }
    @GetMapping("/{boardId}")
    public JpaBoard readBoard (@PathVariable("boardId") Long boardId) {
        log.info("boardRead()");
        //읽고 싶은 데이터를 boardId에 따라 읽겠다.
        //read()를 통해 받은 보드를 리턴함

        return boardService.read(boardId);
    }

    @DeleteMapping("/{boardId}")
    public void deleteBoard (@PathVariable("boardId") Long boardId) {
        log.info("boardRead()");

        boardService.delete(boardId);
        //받은 boardId의 데이터를 삭제 합니다.
        //deleteById를 통해 id로 findId 한다음 Delete함
    }
    @PutMapping("/{boardId}")//put은 수정 할 때 사용함
    public JpaBoard modifyBoard (@PathVariable("boardId") Long boardId,
                                 @RequestBody RequestBoardForm requestBoardForm) {
        //수정할 데이터의 아이디와 데이터를 둘 다 받아 옵니다.
        log.info("modifyBoard(): " + requestBoardForm + ", id: " + boardId);

        return boardService.modify(boardId, requestBoardForm);
        //서비스의 모디파이 매서드를 사용하여 보드 아이디로 찾은 데이터의 내용을 전달 받아온 requestBoardForm 로 셋 해줘서 수정합니다.
        //그리고 그걸 다시 save합니다.
    }
}