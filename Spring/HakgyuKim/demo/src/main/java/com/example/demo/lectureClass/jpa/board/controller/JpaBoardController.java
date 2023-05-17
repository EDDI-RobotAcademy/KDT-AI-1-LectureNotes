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
@RequestMapping("/jpa-board")
public class JpaBoardController {

    final private JpaBoardService boardService;

    @GetMapping("/list")
    public List<JpaBoard> boardList () {
        log.info("boardList()");

        return boardService.list();
    }

    @PostMapping("/register")
    public JpaBoard registerBoard (@RequestBody RequestBoardForm requestBoardForm) {
        log.info("registerBoard()");

        // 등록하고 읽기 페이지로 넘어가기 위한 리턴
        return boardService.register(requestBoardForm.toJpaBoard());
    }

    // 고유 아이디값으로 원하는 board로 가기 위한 {}와 PathVariable
    @GetMapping("/{boardId}")
    public JpaBoard readBoard (@PathVariable("boardId") Long boardId) {
        log.info("BoardRead()");

        // 아이디 값으로 찾은 게시물 리턴
        return boardService.read(boardId);
    }

    // 아이디값으로 지정한 게시물 삭제
    // 리턴할 것이 없으므로 void
    @DeleteMapping("/{boardId}")
    public void deleteBoard (@PathVariable("boardId") Long boardId) {
        log.info("boardRead()");

        boardService.delete(boardId);
    }


    // 지정한 게시물 수정
    // 제목, 내용이 변할 수 있으므로 RequestBoardForm을 RequestBody로 받는다
    // 커지면 바꿀이유가 없는 writer없는 form도 제작하는 것이 좋음
    @PutMapping("/{boardId}")
    public JpaBoard modifyBoard (@PathVariable("boardId") Long boardId,
                                 @RequestBody RequestBoardForm requestBoardForm) {
        log.info("modifyBoard(): " + requestBoardForm + ", id: " + boardId);

        return boardService.modify(boardId, requestBoardForm);
    }

}
