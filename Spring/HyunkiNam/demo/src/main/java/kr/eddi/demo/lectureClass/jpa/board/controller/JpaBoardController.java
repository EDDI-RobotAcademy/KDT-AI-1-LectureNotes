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
// 생성자 없어도 사용할 수 있게 해줌
@RequiredArgsConstructor
@RequestMapping("/jpa-board")
public class JpaBoardController {
    
    // JpaBoardService 사용
    final private JpaBoardService boardService;

    @GetMapping("/list")
    public List<JpaBoard> boardList () {
        log.info("boardList()");

        // list()를 통해 얻은 값 저장
        List<JpaBoard> returnedBoardList = boardService.list();
        log.info("returnedBoardList: " + returnedBoardList);

        // Vue에 리턴
        return returnedBoardList;
    }

    @PostMapping("/register")
    public JpaBoard registerBoard (@RequestBody RequestBoardForm requestBoardForm) {
        log.info("registerBoard()");

        // Vue에서 전달받은 데이터 DB에 저장하고 그 값을 Vue에 리턴
        return boardService.register(requestBoardForm.toJpaBoard());
    }

    @GetMapping("/{boardId}")
    public JpaBoard readBoard (@PathVariable("boardId") Long boardId) {
        log.info("boardRead()");

        // Vue에서 전달받은 boardId와 같은 DB의 데이터를 찾아 Vue에 리턴
        return boardService.read(boardId);
    }

    @DeleteMapping("/{boardId}")
    public void deleteBoard (@PathVariable("boardId") Long boardId) {
        log.info("boardRead()");
        // Vue에서 전달받은 boardId와 같은 DB의 데이터를 찾아 삭제
        boardService.delete(boardId);
    }

    @PutMapping("/{boardId}")
    public JpaBoard modifyBoard (@PathVariable("boardId") Long boardId,
                                 @RequestBody RequestBoardForm requestBoardForm) {
        log.info("modifyBoard(): " + requestBoardForm + ", id: " + boardId);
        // Vue에서 전달받은 boardId와 같은 DB의 데이터를 찾아 수정
        return boardService.modify(boardId, requestBoardForm);
    }
}