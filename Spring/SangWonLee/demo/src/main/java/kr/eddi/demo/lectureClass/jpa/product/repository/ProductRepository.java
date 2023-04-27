package kr.eddi.demo.lectureClass.jpa.product.repository;

import kr.eddi.demo.lectureClass.jpa.board.entity.JpaBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<JpaBoard, Long> {

}
