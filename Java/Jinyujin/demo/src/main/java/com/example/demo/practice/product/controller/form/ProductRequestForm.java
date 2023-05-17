package com.example.demo.practice.product.controller.form;

import com.example.demo.practice.product.entity.ProductEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class ProductRequestForm {

    final private String productName;
    final private Integer price;

    public ProductEntity toProductEntity() {
        return new ProductEntity(productName, price);
    }
}
