package com.example.demo.problem21.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer price;
    private Long accountId;

    @OneToOne(mappedBy = "product", cascade = CascadeType.PERSIST)
    private ProductImage productImage;

    public Product(String name, Integer price, Long accountId, ProductImage productImage) {
        this.name = name;
        this.price = price;
        this.accountId = accountId;
        this.productImage = productImage;

        productImage.setProduct(this);
    }
}
