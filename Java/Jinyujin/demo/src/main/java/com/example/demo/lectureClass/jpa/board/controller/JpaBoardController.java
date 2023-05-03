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
// 데이터를 JSON으로 받게 해주어 코드를 좀 더 직관적으로 짤 수 있게 해줌
@RequiredArgsConstructor
@RequestMapping("/jpa-board")
public class JpaBoardController {
    // 내부 요청을 받는 부분
    // Controller에서 어떤 url이 들어오면 리스트를 리턴할지, 등록인지, 삭제인지 등을 표현해줌

    final private JpaBoardService boardService;
    // Controller로 요청을 받고 실질적으로 데이터를 처리하는 쪽은 Service

    @GetMapping("/list")
    public List<JpaBoard> boardList () {
        // JpaBoard 형태의 리스트를 return
        log.info("boardList()");

        List<JpaBoard> returnedBoardList = boardService.list();
        log.info("returnedBoardList: " + returnedBoardList);

        return returnedBoardList;
    }

    @PostMapping("/register")
    public JpaBoard registerBoard (@RequestBody RequestBoardForm requestBoardForm) {
        log.info("registerBoard()");

        return boardService.register(requestBoardForm.toJpaBoard());
    }

    @GetMapping("/{boardId}")
    // 가변인자로 처리하는 이유
    // 가변인자로 처리하지 않는다면 Id에 해당하는 값을 일일이 다 찾아서 검색해줘야 한다
    // 가변인자로 두면 어떤 수가 오던 일관된 작업을 처리할 수 있다
    public JpaBoard readBoard (@PathVariable("boardId") Long boardId) {
        log.info("boardRead()");

        return boardService.read(boardId);
    }

    @DeleteMapping("/{boardId}")
    public void deleteBoard (@PathVariable("boardId") Long boardId) {
        // delete, 삭제하는 부분이기 때문에 return하는 것 없이 void로 표현
        log.info("boardRead()");

        boardService.delete(boardId);
    }

    @PutMapping("/{boardId}")
    // 여기도 가변인자(id가 뭔지 알 수 없으니까)
    public JpaBoard modifyBoard (@PathVariable("boardId") Long boardId,
                                 // @PathVariable: 가변인자가 있으니까 필요한 어노테이션
                                 @RequestBody RequestBoardForm requestBoardForm) {
        return boardService.modify(boardId, requestBoardForm);
    }
}
