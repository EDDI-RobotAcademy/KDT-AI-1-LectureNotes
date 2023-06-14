package kr.eddi.demo.lectureClass.jpa.board.controller;

import kr.eddi.demo.lectureClass.jpa.board.controller.form.RequestBoardForm;
import kr.eddi.demo.lectureClass.jpa.board.entity.JpaBoard;
import kr.eddi.demo.lectureClass.jpa.board.service.JpaBoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
//현재는 로그를 찍기 위해 사용
@RestController
@RequiredArgsConstructor
//생성자를 만들지 않아도 사용하도록 사용
@RequestMapping("/jpa-board")
public class JpaBoardController {

    final private JpaBoardService boardService;
    //서비스를 가져온다.

    @GetMapping("/list")
    public List<JpaBoard> boardList() {
        //log.info()=>출력이 잘되는가 아닌가 확인
        log.info("boardList()");

        List<JpaBoard> returnedBoardList = boardService.list();
        //보드 서비스의 리스트 메서드를 통해 받은 리스트를 뷰로 보내줌
        log.info("returnedBoardList: " + returnedBoardList);
        return returnedBoardList;
    }

    @PostMapping("/register")
    public JpaBoard registerBoard(@RequestBody RequestBoardForm requestBoardForm) {
        log.info("registerBoard()");

        //받은데이터를 toJpaBoard()을 해서 새로 만든 보드를 서비스의 레지스터를 통해 등록해준다.

        return boardService.register(requestBoardForm.toJpaBoard());
    }

    @GetMapping("/{boardId}")
    public JpaBoard readBoard(@PathVariable("boardId") Long boardId) {
        log.info("boardRead()");
        //받은데이터를
        return boardService.read(boardId);
    }

    @DeleteMapping("/{boardId}")
    public void deleteBoard(@PathVariable("boardId") Long boardId) {
        log.info("boardRead()");

        boardService.delete(boardId);
        //받은 boardId의 데이터를 삭제 합니다.
        //deleteById를 통해 id로 findId 한다음 Delete함
    }
    //{boardId}을 통해서 순차적인 수를 부여해준다.
    @PutMapping("/{boardId}")
    public JpaBoard modifyBoard (@PathVariable("boardId") Long boardId,
                                 @RequestBody RequestBoardForm requestBoardForm) {
        log.info("modifyBoard(): " + requestBoardForm + ", id: " + boardId);

        return boardService.modify(boardId, requestBoardForm);
    }
}