package kr.jinho.jinhokim.testCode.product.repository;

import kr.jinho.jinhokim.testCode.product.entity.TestProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestProductRepository extends JpaRepository<TestProduct, Long> {
}
