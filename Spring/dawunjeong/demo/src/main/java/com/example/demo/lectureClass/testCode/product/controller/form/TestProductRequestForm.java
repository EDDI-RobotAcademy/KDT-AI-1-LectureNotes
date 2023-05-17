package com.example.demo.lectureClass.testCode.product.controller.form;

import com.example.demo.lectureClass.testCode.account.entity.seller.TestSellerAccount;
import com.example.demo.lectureClass.testCode.product.entity.TestProduct;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TestProductRequestForm {
    final private TestSellerAccount testSellerAccount;
    final private String productName;
    final private Integer price;

    public TestProduct toTestProduct() {
        return new TestProduct(testSellerAccount, productName, price);
    }
}
