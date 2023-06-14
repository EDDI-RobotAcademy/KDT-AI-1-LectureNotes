package com.example.demo.secondExam.test22.controller.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Test22ProductResponse {
    private String productName;
    private Integer productCost;
    private String productImg;

    public Test22ProductResponse(String productName, Integer productCost, String productImg) {
        this.productName = productName;
        this.productCost = productCost;
        this.productImg = productImg;
    }
}
