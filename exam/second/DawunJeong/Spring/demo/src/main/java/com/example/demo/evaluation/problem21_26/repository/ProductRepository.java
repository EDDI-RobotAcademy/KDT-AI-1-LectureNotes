package com.example.demo.evaluation.problem21_26.repository;


import com.example.demo.evaluation.problem21_26.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {
    Optional<Product> findByProductName(String productName);
}
