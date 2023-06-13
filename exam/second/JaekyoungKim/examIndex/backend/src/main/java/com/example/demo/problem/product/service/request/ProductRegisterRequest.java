package com.example.demo.problem.product.service.request;

import com.example.demo.problem.product.entity.Product;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ProductRegisterRequest {

    final private String productName;
    final private Integer productPrice;
    final private String productDetails;

    public Product toProduct() {
        return new Product(productName, productPrice, productDetails);
    }
}
