package kr.jinho.jinhokim.practice.controller;


import kr.jinho.jinhokim.practice.controller.form.RequestBoardForm;
import kr.jinho.jinhokim.practice.entity.JpaBoard;
import kr.jinho.jinhokim.practice.service.JpaBoardService;
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
    public List<JpaBoard> boardList() {
        List<JpaBoard> returnedBoardList = boardService.list();
        return returnedBoardList;
    }

    @PostMapping("/register")
    public JpaBoard registerBoard(@RequestBody RequestBoardForm requestBoardForm) {
        return boardService.register(requestBoardForm.toJpaBoard());
    }

    @GetMapping("/{boardId}")
    public JpaBoard readBoard(@PathVariable Long boardId) {
        return boardService.read(boardId);
    }

    @DeleteMapping("/{boardId}")
    public void deleteBoard(@PathVariable Long boardId) {
        boardService.delete(boardId);
    }

    @PutMapping("/{boardId}")
    public JpaBoard modifyBoard(@PathVariable Long boardId,
                                @RequestBody RequestBoardForm requestBoardForm) {
        return boardService.modify(boardId, requestBoardForm);
    }
}
