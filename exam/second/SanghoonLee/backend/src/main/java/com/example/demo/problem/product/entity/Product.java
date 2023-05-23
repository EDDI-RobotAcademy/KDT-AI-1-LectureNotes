package com.example.demo.problem.product.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@ToString
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;
    private Integer productPrice;
    private String productDetails;

    @JsonManagedReference
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<ProductImages> productImagesList = new ArrayList<>();

    public Product(String productName, Integer productPrice, String productDetails) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDetails = productDetails;
    }

    public void setProductImages(ProductImages productImages) {
        productImagesList.add(productImages);
        productImages.setProduct(this);
    }
}
