package com.example.demo.lectureClass.jpa.product.repository;

import com.example.demo.lectureClass.jpa.product.entity.JpaProductTest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProductRepository extends JpaRepository<JpaProductTest, Long> {
}
