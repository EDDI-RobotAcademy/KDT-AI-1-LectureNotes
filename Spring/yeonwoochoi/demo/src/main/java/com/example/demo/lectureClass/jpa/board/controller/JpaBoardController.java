package com.example.demo.lectureClass.jpa.board.controller;

import com.example.demo.lectureClass.jpa.board.controller.form.RequestBoardForm;
import com.example.demo.lectureClass.jpa.board.entity.JpaBoard;
import com.example.demo.lectureClass.jpa.board.service.JpaBoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 어노테이션 : '골뱅이(@)' 기호를 앞에 붙여 사용한다.
// 소스코드를 추가해서 사용할 수 있는 메타 데이터 일종이다.
// 메타 데이터란 애플리케이션이 처리해야할 데이터가 아니라 컴파일 과정과
// 실행 과정에서 코드를 어떻게 처리해야하는지를 알려주는 추가 정보이다.
// 용도 : 1. 컴파일러에게 코드 작성 문법 에러를 체크하도록 정보를 제공해준다.
// 2. 소프트웨어 개발 환경이 빌드나 배포시 코드를 자동으로 생성할 수 있도록 정보 제공해준다.
// 3. 런타임에 특정 기능을 실행하도록 정보를 제공해준다.
@Slf4j
// List<JpaBoard> 를 편하게 사용할 수 있음
@RestController
// 필드에 대한 생성자
@RequiredArgsConstructor
// URL로 요청을 보내면 Controller에서 어떠한 방식으로 처리할지 정의
// (@GetMapping, @PostMapping, @PutMapping, @DeleteMapping 등 사용)
@RequestMapping("/jpa-board") // 큰 주소
public class JpaBoardController {

    // boardService 자동으로 제어 된다.
    final private JpaBoardService boardService;

    // boardList
    // URL Mapping 을 통해 처리
    // 실제로 서비스에서 요청 처리함
    // 프론트에 전달
    @GetMapping("/list") // 작은 주소
    public List<JpaBoard> boardList() {
        // frontend에서 가져온 값이 잘 출력(List<JpaBoard>의 'boardList()') 되는지 log를 찍어본다.
        log.info("boardList()");
        // 아무것도 없는 JpaBoard(게시물) 타입의 리스트에 returnedBoardList
        // 변수를 만들고, boardService.list() 대입 한다.
        List<JpaBoard> returnedBoardList = boardService.list();
        // returnedBoardList 잘 출력되는지 보는 코드
        log.info("returnedBoardList: " + returnedBoardList);

        // returnedBoardList 반환 (요청한 프론트 결과로 보내줌)
        return returnedBoardList;
    }

    // 등록
    @PostMapping("/register") // 작은 주소
    // JpaBoard 타입
    // @RequestBody 받아온 값을 받는다.
    // 프론트에서 requestBoardForm으로 받음
    public JpaBoard registerBoard (@RequestBody RequestBoardForm requestBoardForm) {
        log.info("registerBoard()");

        // 서비스에서 기능
        // 받아온 requestBoardForm를 등록
        // toJpaBoard() -> title, writer, content
        return boardService.register(requestBoardForm.toJpaBoard());
    }

    // 읽기
    // Id값을 읽고 객체를 준다.
    // ("/{boardId}") 가변인자 처리 >> 안하게 되면 100만개 하나 하나 작성
    @GetMapping("/{boardId}")
    // 데이터를 받아올 때는 @RequestParam을 쓴다.
    public JpaBoard readBoard (@PathVariable("boardId") Long boardId) {
        log.info("boardRead()");

        // 서비스에 read(boardId) 전달
        return boardService.read(boardId);
    }

    // 삭제
    // "/{boardId}" Id값을 읽고 아무것도 안줌
    @DeleteMapping("/{boardId}")
    public void deleteBoard (@PathVariable("boardId") Long boardId) {
        // 읽기에 대한 정보를 보려고 log를 찍어본 것
        log.info("boardRead()");

        // 서비스에 delete(boardId) 전달
        boardService.delete(boardId);
    }

    // 수정
    // Id값을 읽고 무언가를 줌
    @PutMapping("/{boardId}")
    // @PathVariable
    // PathVariable를 통하여 boardId 값을 전달한다.
    public JpaBoard modifyBoard (@PathVariable("boardId") Long boardId,
                                 // RequestBoardForm
                                 // toJpaBoard() -> title, writer, content
                                 @RequestBody RequestBoardForm requestBoardForm) {
        log.info("modifyBoard(): " + requestBoardForm + ", id: " + boardId);

        // 서비스에 modify(boardId, requestBoardForm) 전달
        return boardService.modify(boardId, requestBoardForm);
    }
}

