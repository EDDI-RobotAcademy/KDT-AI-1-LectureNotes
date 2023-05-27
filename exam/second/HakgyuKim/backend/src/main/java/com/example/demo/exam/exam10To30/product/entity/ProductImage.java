package com.example.demo.exam.exam10To30.product.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
public class ProductImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private String imageName;

    public ProductImage (String imageName) {
        this.imageName = imageName;
    }

    public static ProductImage of (String imageName) {
        return new ProductImage(imageName);
    }
    public void setProduct (Product product) {
        this.product = product;
    }
}
