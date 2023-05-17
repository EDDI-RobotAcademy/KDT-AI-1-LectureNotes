package kr.eddi.demo.problem1319.product.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;
    private String imgSrc;
    private Integer price;

    public Product(String productName,String imgSrc, Integer price) {
        this.productName = productName;
        this.price = price;
        this.imgSrc=imgSrc;
    }
}