package com.example.demo.secondExam.test22.entity;

import com.example.demo.secondExam.test22.controller.form.Test22ProductResponse;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Test22Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    private String productName;
    private Integer productCost;
    private String productImg;

    public Test22Product(String productName, Integer productCost, String productImg){
        this.productName = productName;
        this.productCost = productCost;
        this.productImg = productImg;
    }

    public Test22ProductResponse toTest22ProductResponse(Test22Product product){
        return new Test22ProductResponse(
                product.productName, product.productCost, product.productImg
        );
    }
}
