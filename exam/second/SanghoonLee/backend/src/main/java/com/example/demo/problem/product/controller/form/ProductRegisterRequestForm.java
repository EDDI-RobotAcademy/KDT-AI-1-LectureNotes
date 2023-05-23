package com.example.demo.problem.product.controller.form;

import com.example.demo.problem.account.service.request.AccountRegisterRequest;
import com.example.demo.problem.product.service.request.ProductRegisterRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class ProductRegisterRequestForm {

    final private String productName;
    final private Integer productPrice;
    final private String productDetails;
    final private String accountToken;

    public ProductRegisterRequest toProductRegisterRequest () {

        return new ProductRegisterRequest(
                productName, productPrice, productDetails);
    }
}
