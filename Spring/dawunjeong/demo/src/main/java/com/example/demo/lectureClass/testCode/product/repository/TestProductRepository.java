package com.example.demo.lectureClass.testCode.product.repository;


import com.example.demo.lectureClass.testCode.product.entity.TestProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestProductRepository extends JpaRepository<TestProduct, Long> {
}
