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

    // ★ JpaBoardService 에 게시판에서 제공하는 모든 서비스가 존재한다.
    // 게시글 리스트, 게시글 등록, 게시글 읽기, 게시글 삭제
    // [] 아직 이 존재에 대해 이해 못함
    final private JpaBoardService boardService;

    // list 는 게시판에 올라와 있는 게시글을 보여줌
    @GetMapping("/list")
    public List<JpaBoard> boardList() {
        log.info("boardList()");
                                        // ↓게시글 리스트를 가져왔다.
        List<JpaBoard> returnedBoardList = boardService.list();
        log.info("returnedBoardList: " + returnedBoardList);
        // ↓게시글 리스트를 반환해줬다.
        return returnedBoardList;
    }

    // register 는 게시판 등록 페이지
    @PostMapping("/register")
    public JpaBoard registerBoard (@RequestBody RequestBoardForm requestBoardForm) {
        log.info("registerBoard()");

        return boardService.register(requestBoardForm.toJpaBoard());
    }

    // 아래 코드는 입력되는 숫자에 따라 해당하는 게시판 글을 보여줌
    @GetMapping("/{boardId}")
    public JpaBoard readBoard (@PathVariable("boardId") Long boardId) {
        log.info("boardRead()");

        return boardService.read(boardId);
    }

    // 아래 코드는 입력되는 숫자에 따라 해당하는 게시판 글을 삭제해줌
    @DeleteMapping("/{boardId}")
    public void deleteBoard (@PathVariable("boardId") Long boardId) {
        log.info("boardRead()");

        boardService.delete(boardId);
    }

}
