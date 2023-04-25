package kr.eddi.demo.lectureClass.vue.problem.controller;

import kr.eddi.demo.lectureClass.jpa.board.eneity.JpaBoard;
import kr.eddi.demo.lectureClass.jpa.board.service.JpaBoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/jpa-board")
public class JpaBoardController {
    final private JpaBoardService boardService;

    @GetMapping("/list")
    public List<JpaBoard> boardList() {
        log.info("boardList()");
        return boardService.list();

    }
}
