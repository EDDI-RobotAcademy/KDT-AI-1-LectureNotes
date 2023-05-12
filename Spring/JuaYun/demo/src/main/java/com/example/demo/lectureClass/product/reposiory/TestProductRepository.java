package com.example.demo.lectureClass.product.reposiory;

import com.example.demo.lectureClass.product.entity.TestProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestProductRepository extends JpaRepository<TestProduct, Long> {
}
