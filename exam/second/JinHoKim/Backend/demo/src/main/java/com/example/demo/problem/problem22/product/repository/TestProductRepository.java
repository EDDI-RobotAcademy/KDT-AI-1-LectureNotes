package com.example.demo.problem.problem22.product.repository;

import com.example.demo.problem.problem22.product.entity.TestProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestProductRepository extends JpaRepository<TestProduct, Long> {
}