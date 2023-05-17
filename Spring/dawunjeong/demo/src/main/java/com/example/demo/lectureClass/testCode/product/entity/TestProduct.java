package com.example.demo.lectureClass.testCode.product.entity;

import com.example.demo.lectureClass.testCode.account.entity.seller.TestSellerAccount;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class TestProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne
    @Getter
    private TestSellerAccount testSellerAccount;

    private String productName;

    private Integer price;

    public TestProduct(TestSellerAccount testSellerAccount, String productName, Integer price) {
        this.testSellerAccount = testSellerAccount;
        this.productName = productName;
        this.price = price;
    }
}
