package kr.eddi.demo.lectureClass.testCode.product.repository;

import kr.eddi.demo.lectureClass.testCode.product.entity.TestProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestProductRepository extends JpaRepository<TestProduct, Long> {
}
