package com.example.demo.exam.exam10To30.product.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer price;

    @OneToOne(mappedBy = "product", cascade = CascadeType.PERSIST)
    private ProductImage productImage;

    public Product(String name, Integer price, ProductImage productImage) {
        this.name = name;
        this.price = price;
        this.productImage = productImage;

        productImage.setProduct(this);
    }
}
