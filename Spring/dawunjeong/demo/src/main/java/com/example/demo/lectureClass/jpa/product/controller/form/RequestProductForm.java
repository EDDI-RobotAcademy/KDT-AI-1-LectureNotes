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
    final private String price;
    final private String manufacturer;
    final private String expirationDate;
    final private String productionDate;
    final private String details;

    public JpaProduct toJpaProduct() {
        return new JpaProduct(name, price, manufacturer,  expirationDate, productionDate, details);
    }
}
