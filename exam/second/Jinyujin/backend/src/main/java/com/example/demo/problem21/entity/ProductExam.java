package com.example.demo.problem21.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class ProductExam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;
    private Integer price;

    @OneToOne(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private ProductImage productImage;

    public ProductExam(String productName, Integer price, ProductImage productImage) {
        this.productName = productName;
        this.price = price;
        this.productImage = productImage;

        productImage.setProduct(this);
    }
}
