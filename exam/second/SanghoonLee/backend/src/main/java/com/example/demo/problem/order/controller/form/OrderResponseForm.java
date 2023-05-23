package com.example.demo.problem.order.controller.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class OrderResponseForm {
    final private Long id;
    final private String productName;
    final private Integer productPrice;
    final private String productDetails;
}
