package com.example.demo.evaluation.problem21_26.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;

    private String productName;
    private Integer productPrice;

    public Product(String email, String productName, Integer productPrice) {
        this.email = email;
        this.productName = productName;
        this.productPrice = productPrice;
    }
}
