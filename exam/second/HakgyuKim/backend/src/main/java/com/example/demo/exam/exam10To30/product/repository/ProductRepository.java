package com.example.demo.exam.exam10To30.product.repository;

import com.example.demo.exam.exam10To30.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
