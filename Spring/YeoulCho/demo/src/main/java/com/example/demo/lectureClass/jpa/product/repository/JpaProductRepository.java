package com.example.demo.lectureClass.jpa.product.repository;


import com.example.demo.lectureClass.jpa.product.entity.reactProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProductRepository extends JpaRepository<reactProduct, Long> {
}
