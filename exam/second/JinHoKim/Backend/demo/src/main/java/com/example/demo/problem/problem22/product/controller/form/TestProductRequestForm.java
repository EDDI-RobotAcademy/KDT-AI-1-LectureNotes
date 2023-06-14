package com.example.demo.problem.problem22.product.controller.form;

import com.example.demo.problem.problem22.product.entity.TestProduct;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TestProductRequestForm {

    final private String productName;
    final private Integer price;

    public TestProduct toTestProduct() {
        return new TestProduct(productName, price);
    }
}