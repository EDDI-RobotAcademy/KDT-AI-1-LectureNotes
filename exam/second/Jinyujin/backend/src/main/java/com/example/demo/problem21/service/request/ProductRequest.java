package com.example.demo.problem21.service.request;

import com.example.demo.problem21.entity.ProductExam;
import com.example.demo.problem21.entity.ProductImage;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ProductRequest {

    final private String productName;
    final private Integer price;
    final private String uniqueRandomName;

    public ProductExam toProduct() {
        return new ProductExam(productName, price, ProductImage.of(uniqueRandomName));
    }
}
