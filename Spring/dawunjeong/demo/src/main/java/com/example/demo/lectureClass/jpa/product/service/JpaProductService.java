package com.example.demo.lectureClass.jpa.product.service;

import com.example.demo.lectureClass.jpa.product.entity.JpaProductTest;

import java.util.List;

public interface JpaProductService {
    List<JpaProductTest> list();
    JpaProductTest register(JpaProductTest jpaProductTest);
    JpaProductTest read(Long productId);

    void delete(Long productId);

}
