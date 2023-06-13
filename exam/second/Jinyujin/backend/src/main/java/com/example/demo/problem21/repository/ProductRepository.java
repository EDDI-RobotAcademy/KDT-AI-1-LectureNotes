package com.example.demo.problem21.repository;

import com.example.demo.problem21.entity.ProductExam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductExam, Long> {
}
