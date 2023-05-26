package com.example.demo.problem21.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class ProductImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private ProductExam product;

    private String uniqueRandomName;

    public ProductImage(String uniqueRandomName) {
        this.uniqueRandomName = uniqueRandomName;
    }

    public static ProductImage of (String uniqueRandomName) {
        return new ProductImage(uniqueRandomName);
    }

    public void setProduct(ProductExam product){
        this.product = product;
    }
}
