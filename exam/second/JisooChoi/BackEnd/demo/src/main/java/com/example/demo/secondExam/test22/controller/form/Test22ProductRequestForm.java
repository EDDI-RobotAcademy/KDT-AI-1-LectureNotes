package com.example.demo.secondExam.test22.controller.form;

import com.example.demo.secondExam.test22.entity.Test22Product;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Test22ProductRequestForm {

    private String productName;
    private Integer productCost;
    private String productImg;
    private String businessUser;

    public Test22Product toTest22Product() {
        return new Test22Product(productName, productCost, productImg);
    }
}
