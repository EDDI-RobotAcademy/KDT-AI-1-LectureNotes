//package kr.eddi.demo.lectureClass.jpa2.board.controller;
//
//import kr.eddi.demo.lectureClass.jpa2.board.controller.form.RequestBoardForm;
//import kr.eddi.demo.lectureClass.jpa2.board.entity.JpaBoard;
//import kr.eddi.demo.lectureClass.jpa2.board.service.JpaBoardService;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
////2
//@Slf4j
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/jpa-board")
//public class JpaBoardController {
//
//    final private JpaBoardService boardServie;
//
//    @GetMapping("/list")//2-1
//    public List<JpaBoard> boardList() {
//        log.info("boardList()");
//        //6
//        List<JpaBoard> returnedBoardList = boardServie.list();
//        log.info("returnedBoardList: " + returnedBoardList);
//        return returnedBoardList;
//    }
//
//    @PostMapping //11
//    public JpaBoard registerBoard(@RequestBody RequestBoardForm requestBoardForm) {
//        log.info("registerBoard()");
//
//        return boardServie.register(requestBoardForm.toJpaBoard());
//    }
//
//    @GetMapping("/{boardId}") //14-1
//    public JpaBoard readBoard(@PathVariable("boardId") Long boardId) {
//        log.info("boardRead()");
//
//        return boardServie.read(boardId);
//    }
//
//    @DeleteMapping("/{boardId}") //14-2
//    public void deleteBoard(@PathVariable("boardId") Long boardId) {
//        log.info("boardRead()");
//
//        boardServie.delete(boardId);
//    }
//
//    @PutMapping("/{boardId}") //17
//    public JpaBoard modifyBoard(@PathVariable("boardId") Long boardId,
//                                @RequestBody RequestBoardForm requestBoardForm) {
//        log.info("modifyBoard(): " + requestBoardForm + ", id: " + boardId);
//
//        return boardServie.modify(boardId, requestBoardForm);
//    }
//}
