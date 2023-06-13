package com.example.demo.problem22_Test;

import com.example.demo.evaluation.problem21_26.controller.form.ProductRegisterRequestForm;
import com.example.demo.evaluation.problem21_26.entity.Product;
import com.example.demo.evaluation.problem21_26.service.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 문제 22번
@SpringBootTest
public class Problem22_Test {
    @Autowired
    private ProductService productService;

    @Test
    @DisplayName("문제 22번. 사업자 회원이 상품 등록하기")
    void 사업자_회원이_상품_등록 () {
        final String email = "business3@test.com";
        final String productName = "상품2";
        final Integer productPrice = 48000;

        ProductRegisterRequestForm productRegisterRequestForm =
                new ProductRegisterRequestForm(email, productName, productPrice);

        Product product = productService.register(productRegisterRequestForm);

        assertEquals(productName, product.getProductName());
    }

}
