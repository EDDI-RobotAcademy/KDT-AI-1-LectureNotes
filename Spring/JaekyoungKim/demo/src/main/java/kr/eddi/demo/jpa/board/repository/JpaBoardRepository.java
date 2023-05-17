package kr.eddi.demo.jpa.board.repository;


import kr.eddi.demo.jpa.board.entity.JpaBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaBoardRepository extends JpaRepository<JpaBoard, Long> {
}// jpqBoard와 long으로 이루어진  저장소 Long은 boardID