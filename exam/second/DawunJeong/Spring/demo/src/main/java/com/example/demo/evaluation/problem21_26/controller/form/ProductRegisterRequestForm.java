package com.example.demo.evaluation.problem21_26.controller.form;

import com.example.demo.evaluation.problem21_26.entity.Product;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ProductRegisterRequestForm {
    final private String email;
    final private String productName;
    final private Integer productPrice;

    public Product toProduct () {
        return new Product(email, productName, productPrice);
    }
}
