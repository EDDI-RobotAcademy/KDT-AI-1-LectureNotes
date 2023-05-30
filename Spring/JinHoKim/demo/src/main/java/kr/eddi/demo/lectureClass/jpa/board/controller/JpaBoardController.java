package kr.eddi.demo.lectureClass.jpa.board.controller;

import kr.eddi.demo.lectureClass.jpa.board.controller.form.RequestBoardForm;
import kr.eddi.demo.lectureClass.jpa.board.entity.JpaBoard;
import kr.eddi.demo.lectureClass.jpa.board.service.JpaBoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/jpa-board")
public class JpaBoardController {

    final private JpaBoardService boardService;

    @GetMapping("/list") //1
    public List<JpaBoard> boardList () {
        log.info("boardList()");

        List<JpaBoard> returnedBoardList = boardService.list();
        log.info("returnedBoardList: " + returnedBoardList);

        return returnedBoardList;
    }

    @PostMapping("/register")//2
    public JpaBoard registerBoard (@RequestBody RequestBoardForm requestBoardForm) {
        log.info("registerBoard()");

        return boardService.register(requestBoardForm.toJpaBoard());
    }

    @GetMapping("/{boardId}")
    public JpaBoard readBoard (@PathVariable("boardId") Long boardId) {
        log.info("boardRead()");

        return boardService.read(boardId);
    }

    @DeleteMapping("/{boardId}")
    public void deleteBoard (@PathVariable("boardId") Long boardId) {
        log.info("boardRead()");

        boardService.delete(boardId);
    }

    @PutMapping("/{boardId}")
    public JpaBoard modifyBoard (@PathVariable("boardId") Long boardId,// PathVaribale 을 통해 가변인자를 찾아 가져옴
                                 @RequestBody RequestBoardForm requestBoardForm) {
        log.info("modifyBoard(): " + requestBoardForm + ", id: " + boardId);

        return boardService.modify(boardId, requestBoardForm);
    }
}