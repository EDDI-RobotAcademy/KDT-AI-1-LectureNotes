package kr.eddi.demo.lectureClass.jpa.board.repository;

import kr.eddi.demo.lectureClass.jpa.board.entity.JpaBoard;
import org.springframework.data.jpa.repository.JpaRepository;
//2
public interface JpaBoardRepository extends JpaRepository<JpaBoard, Long> {
}