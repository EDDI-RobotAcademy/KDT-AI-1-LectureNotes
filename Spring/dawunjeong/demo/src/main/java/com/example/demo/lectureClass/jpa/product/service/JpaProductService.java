package com.example.demo.lectureClass.jpa.product.service;

import com.example.demo.lectureClass.jpa.product.entity.JpaProduct;

import java.util.List;

public interface JpaProductService {
    List<JpaProduct> list();
    JpaProduct register(JpaProduct jpaProduct);
    JpaProduct read(Long productId);

    void delete(Long productId);

}
