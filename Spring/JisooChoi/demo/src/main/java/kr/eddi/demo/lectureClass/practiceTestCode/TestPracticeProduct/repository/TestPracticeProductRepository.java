package kr.eddi.demo.lectureClass.practiceTestCode.TestPracticeProduct.repository;

import kr.eddi.demo.lectureClass.practiceTestCode.TestPracticeProduct.entity.TestPracticeProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TestPracticeProductRepository extends JpaRepository<TestPracticeProduct, Long> {

    Optional<TestPracticeProduct> findByProductName(String productName);

}
