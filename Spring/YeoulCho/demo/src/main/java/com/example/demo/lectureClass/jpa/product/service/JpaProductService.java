package com.example.demo.lectureClass.jpa.product.service;


import com.example.demo.lectureClass.jpa.product.controller.form.RequestProductForm;
import com.example.demo.lectureClass.jpa.product.entity.reactProduct;

import java.util.List;

public interface JpaProductService {
    List<reactProduct> list();
    reactProduct register(reactProduct jpaBoard);

    reactProduct read(Long productId);

    void delete(Long productId);

    reactProduct modify(Long productId, RequestProductForm requestProductForm);
}
