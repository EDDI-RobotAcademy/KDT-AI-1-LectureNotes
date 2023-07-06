package kr.eddi.demo.board.controller;


import kr.eddi.demo.board.controller.form.RequestBoardForm;
import kr.eddi.demo.board.entity.JpaBoard;
import kr.eddi.demo.board.service.JpaBoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/jpa-board")
public class JpaBoardController {

    final private JpaBoardService boardService;

    @GetMapping("/list")
    public List<JpaBoard> boardList () {
        log.info("boardList()");

        List<JpaBoard> returnedBoardList = boardService.list();
        log.info("returnedBoardList: " + returnedBoardList);

        final UUID uniqueId = UUID.randomUUID();
        log.info("uniqueId: " + uniqueId);

        return returnedBoardList;
    }

    @PostMapping("/register")
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
    public JpaBoard modifyBoard (@PathVariable("boardId") Long boardId,
                                 @RequestBody RequestBoardForm requestBoardForm) {
        log.info("modifyBoard(): " + requestBoardForm + ", id: " + boardId);

        return boardService.modify(boardId, requestBoardForm);
    }
}
