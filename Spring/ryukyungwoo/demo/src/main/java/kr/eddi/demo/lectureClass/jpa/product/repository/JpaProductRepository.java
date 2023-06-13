package kr.eddi.demo.lectureClass.jpa.product.repository;

import kr.eddi.demo.lectureClass.jpa.board.entity.JpaBoard;
import kr.eddi.demo.lectureClass.jpa.product.entity.JpaProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProductRepository extends JpaRepository<JpaProduct, Long> {
}
