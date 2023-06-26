package com.example.demo.lectureClass.jpa.product.controller.form;

import com.example.demo.lectureClass.jpa.product.entity.reactProduct;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class RequestProductForm {
    final private String productName;
    final private Integer price;

    public reactProduct toJpaProduct() {
        return new reactProduct(productName, price);
    }
}
