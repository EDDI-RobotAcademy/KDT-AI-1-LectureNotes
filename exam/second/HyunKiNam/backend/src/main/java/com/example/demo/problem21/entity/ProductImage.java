package com.example.demo.problem21.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ProductImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private String uniqueRandomName;

    public ProductImage(String uniqueRandomName) {
        this.uniqueRandomName = uniqueRandomName;
    }

    public static ProductImage of (String uniqueRandomName){
        return new ProductImage(uniqueRandomName);
    }

    public void setProduct (Product product){
        this.product = product;
    }
}
