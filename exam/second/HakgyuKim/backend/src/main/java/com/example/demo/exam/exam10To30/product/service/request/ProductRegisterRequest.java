package com.example.demo.exam.exam10To30.product.service.request;

import com.example.demo.exam.exam10To30.product.entity.Product;
import com.example.demo.exam.exam10To30.product.entity.ProductImage;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ProductRegisterRequest {

    final private String name;
    final private Integer price;
    final private String imageName;

    public Product toProduct() {
        return new Product(name, price, ProductImage.of(imageName));
    }
}
