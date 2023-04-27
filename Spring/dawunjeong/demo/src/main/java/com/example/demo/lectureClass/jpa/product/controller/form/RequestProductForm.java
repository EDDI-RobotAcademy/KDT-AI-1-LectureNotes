package com.example.demo.lectureClass.jpa.product.controller.form;

import com.example.demo.lectureClass.jpa.product.entity.JpaProduct;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class RequestProductForm {
    final private String name;
    final private String details;
    final private String price;

    public JpaProduct toJpaProduct() {
        return new JpaProduct(name, details, price);
    }
}
