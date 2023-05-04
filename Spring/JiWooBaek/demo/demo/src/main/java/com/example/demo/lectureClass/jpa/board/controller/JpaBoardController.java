package com.example.demo.lectureClass.jpa.board.controller;

import com.example.demo.lectureClass.jpa.board.controller.form.RequestBoardForm;
import com.example.demo.lectureClass.jpa.board.entity.JpaBoard;
import com.example.demo.lectureClass.jpa.board.service.JpaBoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/jpa-board") // 전역으로 URL을 걸어두는 것
public class JpaBoardController {

    final private JpaBoardService boardService;

    @GetMapping("/list")  // 그냥 URL(웹 브라우저)에 입력하는 것 (노출됨)
    public List<JpaBoard> boardList () {
        log.info("boardList()");

        List<JpaBoard> returnedBoardList = boardService.list();
        log.info("returnedBoardList: " + returnedBoardList);

        return boardService.list();
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
    public JpaBoard modifyBoard (@PathVariable("boardId") Long boardId, // PathVariable: 가변인자를 생성, 아이디값 받아옴
                                 @RequestBody RequestBoardForm requestBoardForm) {
        log.info("modifyBoard(): " + requestBoardForm + ", id: " + boardId);

        return boardService.modify(boardId, requestBoardForm);
    }

}
