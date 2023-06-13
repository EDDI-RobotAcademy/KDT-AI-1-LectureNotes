package com.example.demo.lectureClass.jpa.product.repository;

import com.example.demo.lectureClass.jpa.board.entity.JpaBoard;
import com.example.demo.lectureClass.jpa.product.entity.JpaProduct;
import org.springframework.data.jpa.repository.JpaRepository;
public interface JpaProductRepository extends JpaRepository<JpaProduct, Long> {
}
