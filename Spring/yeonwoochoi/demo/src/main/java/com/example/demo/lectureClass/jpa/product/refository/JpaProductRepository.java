package com.example.demo.lectureClass.jpa.product.refository;

import com.example.demo.lectureClass.jpa.product.entity.JpaProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProductRepository  extends JpaRepository<JpaProduct, Long> {

}
