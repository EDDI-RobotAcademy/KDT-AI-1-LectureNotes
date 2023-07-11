package board.controller;

import board.controller.form.RequestBoardForm;
import board.entity.JpaBoard;
import board.service.JpaBoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 클라이언트의 요청에 따라 응답을 처리할 Controller입니다.
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/jpa-board")
public class JpaBoardController {

    /*
     JpaBoardService 인터페이스 타입의 boardService 선언하여
     JpaBoardService 인터페이스를 구현한 클래스의 인스턴스를 사용하겠다는 의미입니다.
     @RequiredArgsConstructor 이 어노테이션에 의해 인터페이스를 직접 사용할 수 있게 됩니다.
     */
    final private JpaBoardService boardService;

    /*
    "/list" URL로 요청이 오면 실행되는 controller입니다.
    boardService의 list() 매서드를 사용하여 조회한 JpaBoard 리스트를
    returnedBoardList 변수에 대입하고 returnedBoardList를 반환합니다.
     */
    @GetMapping("/list")
    public List<JpaBoard> boardList () {
        log.info("boardList()");

        List<JpaBoard> returnedBoardList = boardService.list();
        log.info("returnedBoardList: " + returnedBoardList);

        return returnedBoardList;
    }

    /*
    "/register" URL로 요청이 오면 실행되는 controller입니다.
    boardService의 register() 매서드를 사용하여
    외부에서 전달받은 requestBoardForm로 JpaBoard 객체를 생성하고 그 객체를 반환합니다.
     */
    @PostMapping("/register")
    public JpaBoard registerBoard (@RequestBody RequestBoardForm requestBoardForm) {
        log.info("registerBoard()");

        return boardService.register(requestBoardForm.toJpaBoard());
    }

    /*
    "/{boardId}" URL로 요청이 오면 실행되는 controller입니다.
    boardService의 read() 매서드를 사용하여
    boardId를 토대로 JpaBoard를 찾아 반환합니다.

    @PathVariable를 통해 URL이 동적으로 변경될 수 있다는 것을 알려주고
    그 URL 경로의 변수 값을 이 매서드의 인자로 사용하겠다는 것을 알려줍니다.
     */
    @GetMapping("/{boardId}")
    public JpaBoard readBoard (@PathVariable("boardId") Long boardId) {
        log.info("boardRead()");

        return boardService.read(boardId);
    }

    /*
    "/{boardId}" URL로 요청이 오면 실행되는 controller입니다.
    boardService의 delete() 매서드를 사용하여
    boardId를 토대로 JpaBoard를 찾아 그 객체를 삭제합니다.

    @PathVariable를 통해 URL이 동적으로 변경될 수 있다는 것을 알려주고
    그 URL 경로의 변수 값을 이 매서드의 인자로 사용하겠다는 것을 알려줍니다.
     */
    @DeleteMapping("/{boardId}")
    public void deleteBoard (@PathVariable("boardId") Long boardId) {
        log.info("boardRead()");

        boardService.delete(boardId);
    }

    /*
    "/{boardId}" URL로 요청이 오면 실행되는 controller입니다.
    boardService의 modify() 매서드를 사용하여
    boardId를 토대로 JpaBoard를 찾아 requestBoardForm 데이터로 객체를 변경합니다.

    @PathVariable를 통해 URL이 동적으로 변경될 수 있다는 것을 알려주고
    그 URL 경로의 변수 값을 이 매서드의 인자로 사용하겠다는 것을 알려줍니다.
     */
    @PutMapping("/{boardId}")
    public JpaBoard modifyBoard (@PathVariable("boardId") Long boardId,
                                 @RequestBody RequestBoardForm requestBoardForm) {
        log.info("modifyBoard(): " + requestBoardForm + ", id: " + boardId);

        return boardService.modify(boardId, requestBoardForm);
    }
}