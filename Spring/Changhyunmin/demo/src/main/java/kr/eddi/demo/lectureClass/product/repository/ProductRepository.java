package kr.eddi.demo.lectureClass.product.repository;

import kr.eddi.demo.lectureClass.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
