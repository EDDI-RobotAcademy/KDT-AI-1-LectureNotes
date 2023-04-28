//package kr.eddi.demo.lectureClass.jpa2.board.service;
//
//import kr.eddi.demo.lectureClass.jpa2.board.controller.form.RequestBoardForm;
//import kr.eddi.demo.lectureClass.jpa2.board.entity.JpaBoard;
//import kr.eddi.demo.lectureClass.jpa2.board.repository.JpaBoardRepository;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Slf4j
//@Service
//@RequiredArgsConstructor
////5
//public class JpaBoardServiceImpl implements JpaBoardService {
//
//    final private JpaBoardRepository boardRepository;
//
//    @Override
//    public List<JpaBoard> list() {
//        return boardRepository.findAll(Sort.by(Sort.Direction.DESC, "boardId"));
//    }
//
//    @Override//10
//    public JpaBoard register(JpaBoard jpaBoard) {
//        return boardRepository.save(jpaBoard);
//    }
//
//    @Override //13-1
//    public JpaBoard read(Long boardId) {
//        Optional<JpaBoard> maybeJpaBoard = boardRepository.findById(boardId);
//
//        if (maybeJpaBoard.isEmpty()) {
//            log.info("정보가 없습니다!");
//            return null;
//        }
//        return maybeJpaBoard.get();
//    }
//
//    @Override //13-2
//    public void delete(Long boardId) {
//        boardRepository.deleteById(boardId);
//    }
//
//    @Override //16
//    public JpaBoard modify(Long boardId, RequestBoardForm requestBoardForm) {
//        Optional<JpaBoard> maybeJpaBoard = boardRepository.findById(boardId);
//
//        if (maybeJpaBoard.isEmpty()) {
//            log.info("정보가 없습니다!");
//            return null;
//        }
//
//        JpaBoard board = maybeJpaBoard.get();
//        board.setTitle(requestBoardForm.getTitle());
//        board.setContent(requestBoardForm.getContent());
//
//        return boardRepository.save(board);
//    }
//
//}
