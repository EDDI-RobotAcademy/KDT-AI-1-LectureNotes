package com.example.demo.homework.BoardProblem.controller;

import com.example.demo.homework.BoardProblem.controller.form.RequestBoardForm;
import com.example.demo.homework.BoardProblem.entity.JpaBoard;
import com.example.demo.homework.BoardProblem.service.JpaBoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/jpa-board")
public class JpaBoardController {

    // JpaBoardService 객체를 선언하고 이를 멤버 변수로 선언
    // 이를 통해 Service 에서 정의된 메소드를 사용할 수 있다.
    final private JpaBoardService boardService;

    @GetMapping("/list")
    // boardList 라는 메소드를 정의한다 반환값은 JpaBoard 객체의 List 이다.
    public List<JpaBoard> boardList () {
        log.info("boardList");

        // JpaBoardService 객체의 list() 메소드를 호출해
        // DB에 게시판 리스트를 조회한 뒤 결과를 List<JpaBoard> 객체로 반환
        List<JpaBoard> returnedBoardList = boardService.list();
        log.info("returnedBoardList: " + returnedBoardList);

        return returnedBoardList;
    }

    // @RequestBody 어노테이션은 Body 에 있는 데이터를 읽어서 객체로 만들어준다.
    // 요청 데이터가 JSON 형식이라면 Spring 에서 객체로 변환한다.
    @PostMapping("/register")
    public JpaBoard registerBoard (@RequestBody RequestBoardForm requestBoardForm) {
        log.info("registerBoard()");

        // boardService 객체의 register 메소드를 호출하여 요청데이터를 저장하고
        // 저장된 데이터를 반환한다.
        return boardService.register(requestBoardForm.toJpaBoard());
    }

    // {boardId} 가변인자처리
    @GetMapping("/{boardId}")
    // @PathVariable("boardId") URL 에서 {boardId} 를 읽어서 boardId 변수에 저장
    public JpaBoard readBoard (@PathVariable("boardId") Long boardId) {
        log.info("boardRead()");

        // boardService 객체의 read 메소드를 호출하여
        // 요청한 boardId 에 해당하는 데이터를 반환
        return boardService.read(boardId);
    }

    // 읽기와 삭제는 동일한 방식으로 처리
    @DeleteMapping("/{boardId}")
    public void deleteBoard (@PathVariable("boardId") Long boardId) {
        log.info("boardRead()");

        // 읽기와 동일
        boardService.delete(boardId);
    }

    @PutMapping("/{boardId}")
    // 게시판 수정
    public JpaBoard modifyBoard (@PathVariable("boardId") Long boardId,
                                 @RequestBody RequestBoardForm requestBoardForm) {
        log.info("modifyBoard(): " + requestBoardForm + ", id: " + boardId);

        // boardService 객체의 modify 메소드를 호출하여
        // 요청한 boardId 에 해당하는 데이터를 수정하고 수정된 데이터를 반환
        return boardService.modify(boardId, requestBoardForm);
    }
}
