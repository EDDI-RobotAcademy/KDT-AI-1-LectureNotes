package com.example.demo.practice.product.service;

import com.example.demo.practice.product.controller.form.ProductRequestForm;
import com.example.demo.practice.product.entity.ProductEntity;

import java.util.List;

public interface ProductService {

    List<ProductEntity> productList();

    ProductEntity productRegister(ProductEntity productEntity);

    ProductEntity productRead(Long productId);

    void productDelete(Long productId);

    ProductEntity productModify(Long productId, ProductRequestForm productRequestForm);
}
