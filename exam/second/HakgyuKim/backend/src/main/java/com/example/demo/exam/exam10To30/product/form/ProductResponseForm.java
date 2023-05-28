package com.example.demo.exam.exam10To30.product.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ProductResponseForm {

    final private Long id;
    final private String name;
    final private Integer price;
    final private String productImageName;
}
