package kr.eddi.demo.lectureClass.testCode.problem.product.repository;

import kr.eddi.demo.lectureClass.testCode.problem.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByProductName(String productName);
    Optional<Product> findById(Long id);
}
