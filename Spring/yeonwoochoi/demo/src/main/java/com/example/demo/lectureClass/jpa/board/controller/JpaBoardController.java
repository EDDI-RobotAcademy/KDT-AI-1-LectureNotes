package com.example.demo.lectureClass.jpa.board.controller;

import com.example.demo.lectureClass.jpa.board.controller.form.RequestBoardForm;
import com.example.demo.lectureClass.jpa.board.entity.JpaBoard;
import com.example.demo.lectureClass.jpa.board.service.JpaBoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
//  List<JpaBoard> 를 사용할 수 있음 (편하게 사용할 수 있게 만든 것)
@RestController
@RequiredArgsConstructor
@RequestMapping("/jpa-board")
public class JpaBoardController {

    // boardService 자동으로 제어 된다.
    final private JpaBoardService boardService;

    // URL Mapping 을 통해 처리
    // 실제로 서비스에서 요청 처리함
    // 프론트에 전달
    @GetMapping("/list")
    public List<JpaBoard> boardList() {
        log.info("boardList()");
        List<JpaBoard> returnedBoardList = boardService.list();
        log.info("returnedBoardList: " + returnedBoardList);

        return returnedBoardList;
    }

    // 등록
    @PostMapping("/register")
    public JpaBoard registerBoard (@RequestBody RequestBoardForm requestBoardForm) {
        log.info("registerBoard()");

        return boardService.register(requestBoardForm.toJpaBoard());
    }

    // 읽기
    // Id값을 읽고 객체를 준다.
    // ("/{boardId}") 가변인자 처리 >> 안하게 되면 100만개 하나 하나 작성
    @GetMapping("/{boardId}")
    public JpaBoard readBoard (@PathVariable("boardId") Long boardId) {
        log.info("boardRead()");

        // 서비스에 리드에 전달
        return boardService.read(boardId);
    }

    // 삭제
    // "/{boardId}" Id값을 읽고
    // 아무것도 안줌
    @DeleteMapping("/{boardId}")
    public void deleteBoard (@PathVariable("boardId") Long boardId) {
        log.info("boardRead()");

        boardService.delete(boardId);
    }

    // 수정
    // Id값을 읽고
    // 무언가를 줌
    @PutMapping("/{boardId}")
    public JpaBoard modifyBoard (@PathVariable("boardId") Long boardId,
                                 @RequestBody RequestBoardForm requestBoardForm) {
        log.info("modifyBoard(): " + requestBoardForm + ", id: " + boardId);

        return boardService.modify(boardId, requestBoardForm);
    }
}

